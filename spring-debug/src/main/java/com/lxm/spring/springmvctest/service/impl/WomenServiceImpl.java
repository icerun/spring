package com.lxm.spring.springmvctest.service.impl;


import java.util.Set;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/7 0:19
 * @Version 1.0
 */
public class WomenServiceImpl extends UserServiceImpl {

	/**
	 * 人会说话
	 *
	 * @param userClasses@return
	 */
	@Override
	public void sayHello(Set<Class<?>> userClasses) {
		System.out.println("女人类-------》》》》"+userClasses);
	}
}
