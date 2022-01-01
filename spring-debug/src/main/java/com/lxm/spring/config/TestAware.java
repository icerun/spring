package com.lxm.spring.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * 功能描述: 自己的组件 需要使用spring ioc的底层组件的时候,比如 ApplicationContext等 我们可以通过实现XXXAware接口来实现
 */
@Component
public class TestAware  implements ApplicationContextAware, BeanNameAware {
	@Override
	public void setBeanName(String name) {
		System.out.println("current bean name is :【"+name+"】");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

	}
}
