package com.lxm.spring.domain;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/1 16:46
 * @Version 1.0
 */
public class Person {
	@Value("${person.id:111}")
	private int id;
	@Value("${person.nick_name:'linyu'}")
	private String nickName;
	@Value("${person.age:20}")
	private int age;
	@Value("${person.gender:'WW'}")
	private String gender;
	@Value("${exten.address:'ddd'}")
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", nickName='" + nickName + '\'' +
				", age=" + age +
				", gender='" + gender + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
