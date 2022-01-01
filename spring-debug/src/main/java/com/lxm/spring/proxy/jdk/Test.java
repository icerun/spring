package com.lxm.spring.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
		Customer customer = new Customer("张三");
		Handler handler = new Handler(customer);
		RentingHouse o = (RentingHouse) Proxy.newProxyInstance(customer.getClass().getClassLoader(), customer.getClass().getInterfaces(), handler);
		o.signContract();
		System.out.println();
	}
}

/**
 * 租房业务
 */
interface RentingHouse {
	//签订租房合同
	void signContract();
}

/**
 * 客户1123132
 */
class Customer implements RentingHouse {
	private String name;

	public Customer(String name) {
		this.name = name;
	}

	@Override
	public void signContract() {
		System.out.println(this.name + "租到了房子");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

/**
 * 调用处理器
 */
class Handler implements InvocationHandler {

	Object object;

	//找我就给他办事
	public Handler(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		findHouse();
		Object returnValue = method.invoke(object, args);

		giveMeMoney();
		return returnValue;
	}

	public void findHouse() {
		System.out.println("中介：正在找房子");
	}

	public void giveMeMoney() {
		System.out.println("中介：收取中介费");
	}
}
