package com.lxm.spring.domain;
/**
 * 功能描述: 自定义标签测试
 * @author luxiaomeng
 * @date  2021/5/18 19:29
 * @修改日志：
 */
public class Author {

	private String id;
	private String username;
	private String sex;
	private Address address;

	@Override
	public String toString() {
		return "Author{" +
				"id='" + id + '\'' +
				", username='" + username + '\'' +
				", sex='" + sex + '\'' +
				", address=" + address +
				'}';
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
