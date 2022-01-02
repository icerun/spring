package com.lxm.spring.aoptest.service;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/1 17:26
 * @Version 1.0
 */
@Component
public class MathCalculator {

	public int divideNumber(int i,int j){
		return i+j;
	}
}
