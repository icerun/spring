package com.lxm.spring.domain;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MyFactoryBean implements FactoryBean<MyBean> {
	@Override
	public MyBean getObject() throws Exception {
		return new MyBean();
	}

	@Override
	public Class<?> getObjectType() {
		return MyBean.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+"MyFactoryBean";
	}
}
