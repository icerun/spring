package com.lxm.spring.mytest.myspring.autowire;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {
	private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
	private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>();

	public ApplicationContext(Class<AppConfig> configClass) throws ClassNotFoundException {

		List<Class<?>> classList = new ArrayList<>();
		//扫描，得到class
		ComponentScan componentScanAnnotation = configClass.getAnnotation(ComponentScan.class);
		//com.lxm.spring.mytest.myspring.service
		String path = componentScanAnnotation.value();
		path = path.replace(".", "/");
		ClassLoader classLoader = ApplicationContext.class.getClassLoader();
		URL url = classLoader.getResource(path);
		File file = new File(url.getFile());

		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				String absolutePath = f.getAbsolutePath();
				absolutePath = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"));
				absolutePath = absolutePath.replace("\\", ".");
				Class<?> aClass = classLoader.loadClass(absolutePath);
				classList.add(aClass);
			}
		}
		// 过滤
		// 解析这些类
		for (Class<?> clazz : classList) {
			if (clazz.isAnnotationPresent(Component.class)) {
				BeanDefinition beanDefinition = new BeanDefinition();
				beanDefinition.setBeanClass(clazz);
				Component annotation = clazz.getAnnotation(Component.class);
				String beanName = annotation.value();
				if (clazz.isAnnotationPresent(Scope.class)) {
					Scope scope = clazz.getAnnotation(Scope.class);
				} else {
					// 单例
					beanDefinition.setScope("singleton");
				}
				beanDefinitionMap.put(beanName, beanDefinition);
			}
		}


		// 基于class去创建单例bean  
		instanceSingletonBean();
	}

	private void instanceSingletonBean() {
		for (String beanName : beanDefinitionMap.keySet()) {
			BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
			if ("singleton".equals(beanDefinition.getScope())) {
				// 创建bean
				if (!singletonObjects.containsKey(beanName)) {
					Object bean = doCreateBean(beanName, beanDefinition);
					singletonObjects.put(beanName, bean);
				}
			}
		}
	}

	public Object getBean(String beanName) {
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		if ("prototype".equals(beanDefinition.getScope())) {
			// 创建bean
			return doCreateBean(beanName, beanDefinition);
		} else if ("singleton".equals(beanDefinition.getScope())) {
			Object bean = singletonObjects.get(beanName);
			// 单例池去拿
			if (bean == null) {
				bean = doCreateBean(beanName, beanDefinition);
				singletonObjects.put(beanName, bean);
				return bean;
			}
			return bean;

		}
		return null;
	}

	public Object doCreateBean(String beanName, BeanDefinition beanDefinition) {

		// 1.实例化
		Class<?> beanClass = beanDefinition.getBeanClass();
		Object bean = null;
		try {
			bean = beanClass.getDeclaredConstructor().newInstance();

			// 2.属性填充
			Field[] declaredFields = beanClass.getDeclaredFields();
			for (Field field : declaredFields) {
				if (field.isAnnotationPresent(Autowired.class)) {
					// 属性赋值
					// 考虑问题，user很可能还没实例化
					Object bean1 = getBean(field.getName());
					field.setAccessible(true);
					field.set(bean,bean1);
				}
			}
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		return bean;
	}
}
