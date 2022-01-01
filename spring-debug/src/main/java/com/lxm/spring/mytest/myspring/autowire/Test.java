package com.lxm.spring.mytest.myspring.autowire;

import com.lxm.spring.mytest.myspring.autowire.service.User;
import com.lxm.spring.mytest.myspring.autowire.service.UserService;

/**
 * 功能描述:
 * @return
 * @author luxiaomeng
 * @date  2021/3/6 21:17
 * @修改日志：
 */
public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		ApplicationContext applicationContext = new ApplicationContext(AppConfig.class);
		UserService userService = (UserService) applicationContext.getBean("userService");
		System.out.println(userService.toString());

	}
}
