package com.lxm.spring.proxy.cglib;


import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 功能描述: 以租房案例实现jdk的动态代理
 * 中介租房流程： 找房源（中介）-签合同-收取中介费（中介）
 *  角色： 顾客-》被代理类
 *         中介-》代理类
 *         接口
 * @author luxiaomeng
 * @date 2020/8/14   14:46
 * 修改日志: 暂无
 */
public class DynamicProxy {

	public static void main(String[] args) {
		// 动态代理创建的class文件存储到本地
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "d:\\class");
		// 通过CGLIB动态代理获取代理对象的过程，创建调用的对象，在后续创建过程中EnhanceKey的对象，所以在进行enhancer对象创建的时候需要把Enhancerkey(newInstance)对象准备好
		Enhancer enhancer = new Enhancer();
		// 设置enhancer对象的父类
		enhancer.setSuperclass(Customer.class);
		// 设置enhancer的回调对象
		enhancer.setCallback(new Handler());
		// 创建代理对象
		Customer proxy= (Customer)enhancer.create();
		// 通过代理对象调用目标方法
		proxy.signContract();

		proxy.hahha();

	}


}

/**
 * 客户
 */
class Customer {
	private String name;


	public void signContract() {
		System.out.println( "租到了房子");
	}
	public void hahha() {
		System.out.println( "haha");
	}
}

/**
 * 调用处理器
 */
class Handler implements MethodInterceptor {

	public void findHouse() {
		System.out.println("中介：正在找房子");
	}

	public void giveMeMoney() {
		System.out.println("中介：收取中介费");
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		findHouse();
		Object invoke = methodProxy.invokeSuper(o, objects);
		giveMeMoney();
		return invoke;
	}
}
