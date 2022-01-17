package com.lxm.spring.designmodel.mytests;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/16 19:36
 * @Version 1.0
 */
public class AbstractTest {

	public static void main(String[] args) {
		MyBuilder myBuilder = new MyBuilder(new Aabstract());
		Aabstract beanDen = (Aabstract) myBuilder.getBeanDen();
		beanDen.sayHello("你好世界----hello world----！！！！");
	}


}

class MyBuilder {

	AAA beanDen;

	MyBuilder(AAA aaa) {
		this.beanDen = aaa;

	}

	public AAA getBeanDen() {
		return this.beanDen;
	}

}

abstract class AAA {


}

class Aabstract extends AAA {

	public void sayHello(String val) {
		System.out.println(val);
	}

}
