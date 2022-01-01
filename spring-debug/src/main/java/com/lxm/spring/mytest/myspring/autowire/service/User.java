package com.lxm.spring.mytest.myspring.autowire.service;

import com.lxm.spring.mytest.myspring.autowire.Component;
import com.lxm.spring.mytest.myspring.autowire.ComponentScan;
import com.lxm.spring.mytest.myspring.autowire.Lazy;
import com.lxm.spring.mytest.myspring.autowire.Scope;
@Component("user")
//@ComponentScan("user")
//@Lazy
//@Scope("prototype")
public class User {
	private String name;

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				'}';
	}
	public User() {
		this.name = "name";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

