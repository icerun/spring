package com.lxm.spring.mytest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/6/9 23:44
 * @Version 1.0
 */
public class UserServiceImpl {
	public UserServiceImpl() {
		try {
			Context context = new InitialContext();
			context.lookup("");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
