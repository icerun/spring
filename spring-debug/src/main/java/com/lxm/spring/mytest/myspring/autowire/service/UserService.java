package com.lxm.spring.mytest.myspring.autowire.service;


import com.lxm.spring.mytest.myspring.autowire.Autowired;
import com.lxm.spring.mytest.myspring.autowire.Component;

@Component("userService")
public class UserService {
	@Autowired
	private User user;

	public void test() {
		System.out.println(user.toString());
	}
}
