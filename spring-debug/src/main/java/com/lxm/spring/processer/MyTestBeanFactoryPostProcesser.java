package com.lxm.spring.processer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 功能描述: MyTestBeanFactoryPostProcesser
 * 在beanDefinition 被加载进入容器后，对象实例化之前进行
 * beanDe
 * @author luxiaomeng
 * @date  2021/3/13 21:53
 * @修改日志：
 */
@Component
public class MyTestBeanFactoryPostProcesser implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("IOC容器调用BeanFactoryPostProcessor");
		for (String name : beanFactory.getBeanDefinitionNames()) {
			System.out.println("IOC-BeanFactoryPostProcessor-BeanDefinitionName"+name);
		}
	}
}
