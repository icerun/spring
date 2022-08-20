package com.lxm.spring.factorys.service;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/22 22:14
 * @Version 1.0
 */
public interface ProductFactory {
	/**
	 * 工厂造车
	 *
	 * @param type
	 * @return
	 */
	Car create(String type);
}
