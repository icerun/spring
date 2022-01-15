package com.lxm.spring.springmvctest;

import com.lxm.spring.springmvctest.config.UserConfig;
import com.lxm.spring.springmvctest.service.UserServce;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/7 0:17
 * @Version 1.0
 */
public class SpringMvcTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
//		UserServce bean = context.getBean(UserServce.class);
////		bean.sayHello();


	}

}
