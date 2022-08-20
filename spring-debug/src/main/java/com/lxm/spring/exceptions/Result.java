package com.lxm.spring.exceptions;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/2/14 21:14
 * @Version 1.0
 */
public class Result {
	private String code;
	private String message;

	public String fail(String message) {
		this.message = message;
		return this.message;
	}

	public String success(String message) {
		this.message = message;
		return this.message;
	}
}
