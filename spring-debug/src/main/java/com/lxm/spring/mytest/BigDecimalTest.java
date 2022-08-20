package com.lxm.spring.mytest;

import java.math.BigDecimal;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/25 15:18
 * @Version 1.0
 */
public class BigDecimalTest {

	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal("200.22");
		BigDecimal multiply = bigDecimal.multiply(new BigDecimal("100"));
		System.out.println(multiply);
		long l = multiply.longValue();
		System.out.println(l);

	}

}
