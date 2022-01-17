package com.lxm.spring.designmodel.simples.factorys;

import com.lxm.spring.designmodel.simples.factorys.domain.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/17 23:43
 * @Version 1.0
 */
@Component
public class UserFactory implements FactoryBean<User> {


	@Override
	public User getObject() throws Exception {
		return new User("阿波罗",27);
	}


	@Override
	public Class<?> getObjectType() {
		return null;
	}


	@Override
	public boolean isSingleton() {
		return FactoryBean.super.isSingleton();
	}
}
