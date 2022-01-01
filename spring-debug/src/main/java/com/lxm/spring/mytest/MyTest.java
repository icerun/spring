package com.lxm.spring.mytest;

import com.lxm.spring.domain.Author;
import com.lxm.spring.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 功能描述: spring源码阅读入口
 * @translator luxiaomeng
 * 个人理想: 人人都有源码读
 * @辅助功能： 查看类图 ctrl+alt+shift + u
 * @阅读说明： 作者
 * 		1.上行原文，下行翻译
 * 		2.【说明】：对源码的看法
 * 		3.【重点】：spring的重点
 * @date  2021/3/5 16:26
 */
public class MyTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//		Object bean = applicationContext.getBean("user");
//		System.out.println(bean.toString());
		Author bean = (Author) applicationContext.getBean("customer");
		System.out.println(bean.toString());
	}
}
