package com.lxm.spring.mytest;

import com.lxm.spring.aoptest.config.AopConfig;
import com.lxm.spring.config.PropertyConfig;
import com.lxm.spring.domain.Person;
import com.lxm.spring.aoptest.service.MathCalculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
////		Object bean = applicationContext.getBean("user");
////		System.out.println(bean.toString());
//		Author bean = (Author) applicationContext.getBean("customer");
//		System.out.println(bean.toString());

		testPerson2();
//		testPerson();
	}

	public static void testPerson2(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		MathCalculator mathCalculator = (MathCalculator) context.getBean("mathCalculator");
		int divide = mathCalculator.divideNumber(2, 1);
		System.out.println(divide);


	}

	public static void testPerson(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertyConfig.class);
		Person bean = context.getBean(Person.class);
		System.out.println(bean);


	}


}
