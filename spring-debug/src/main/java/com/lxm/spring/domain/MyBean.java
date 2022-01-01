package com.lxm.spring.domain;

public class MyBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.toString() + "MyBean";
	}
}
