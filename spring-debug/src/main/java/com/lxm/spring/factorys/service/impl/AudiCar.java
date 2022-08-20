package com.lxm.spring.factorys.service.impl;

import com.lxm.spring.factorys.service.Car;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/23 16:28
 * @Version 1.0
 */
public class AudiCar implements Car {
	@Override
	public void run() {
		System.out.println("开着奥迪跑在高速公路上");
	}
}
