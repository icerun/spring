package com.lxm.spring.aoptest;

import com.lxm.spring.aoptest.config.AopConfig;
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

		testPerson2();
	}

	public static void testPerson2(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		MathCalculator mathCalculator = (MathCalculator) context.getBean("mathCalculator");
		int divide = mathCalculator.divideNumber(2, 1);
		System.out.println(divide);


	}


}
