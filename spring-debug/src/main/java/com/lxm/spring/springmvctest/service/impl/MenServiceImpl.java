package com.lxm.spring.springmvctest.service.impl;



import java.util.Set;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/7 0:20
 * @Version 1.0
 */
public class MenServiceImpl extends UserServiceImpl {

	/**
	 * 人会说话
	 *
	 * @param userClasses@return
	 */
	@Override
	public void sayHello(Set<Class<?>> userClasses) {
		System.out.println("男人类-------》》》》"+userClasses);

	}

}
