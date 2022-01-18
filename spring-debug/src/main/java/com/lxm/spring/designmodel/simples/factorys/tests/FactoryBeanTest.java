package com.lxm.spring.designmodel.simples.factorys.tests;

import com.lxm.spring.designmodel.simples.factorys.UserFactory;
import com.lxm.spring.designmodel.simples.factorys.config.UserConfig;
import com.lxm.spring.designmodel.simples.factorys.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/17 23:43
 * @Version 1.0
 */
public class FactoryBeanTest {
	public static void main(String[] args) throws Exception {
		test1();
	}



	public static void test1() throws Exception {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserConfig.class);
		UserFactory userFactory = applicationContext.getBean(UserFactory.class);
		User user = userFactory.getObject();
		System.out.println(user);
	}
}
