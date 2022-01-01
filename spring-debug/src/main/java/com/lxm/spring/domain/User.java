package com.lxm.spring.domain;

import org.springframework.beans.factory.annotation.Value;

/**
 * 功能描述: 定义的对象
 * @author luxiaomeng
 * @date  2021/3/12 14:09
 * @修改日志：
 *
 * <p>什么是bean的生命周期？
 * 		bean的创建--->初始化--->销毁方法
 * 		由容器管理Bean的生命周期，我们可以通过自己制定bean的初始化方法和销毁方法
 * 			1.@Bean(initMethod = "init",destroyMethod = "destory")
 * 			2.@Component注解下，实现InitializingBean,DisposableBean接口
 * 		    3.JSR250:	@Component注解下，方法上使用注解@PostConstruct 和@ProDestory标注
 * 		    4.spring的beanPostProcessor的bean的后置处理器会拦截所有bean创建过程
 * 		    	postProcessBeforeInitialization 在init方法之前调用
 * 		    	postProcessAfterInitialization 在init方法之后调
 * 		针对单实例bean的话，容器启动的时候，bean的对象就创建了，而且容器销毁的时候，也会调用Bean的销毁方法
 * 		针对多实例bean的话,容器启动的时候，bean是不会被创建的而是在获取bean的时候被创建，而且bean的销毁不受IOC容器的管理
 *
 */
public class User {

	/**
	 * 通过@Value + @PropertySouce来给组件复制
	 *
	 *  而@PropertySouce {@link com.lxm.spring.config.MyCondition}
	 */
//	@Value("name1")
	private String name = "abc";
	@Value("#{28-8}")
	private int age;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = "name2";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
