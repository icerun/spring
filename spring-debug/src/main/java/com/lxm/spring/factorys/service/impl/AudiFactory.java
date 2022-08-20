package com.lxm.spring.factorys.service.impl;

import com.lxm.spring.factorys.service.Car;
import com.lxm.spring.factorys.service.ProductFactory;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/23 16:38
 * @Version 1.0
 */
@Service
public class AudiFactory implements ProductFactory {

	/**
	 * 工厂造车
	 *
	 * @param type
	 * @return
	 */
	@Override
	public Car create(String type) {
		if(!"audi".equals(type)){
			return null;
		}
		return new AudiCar();
	}
}
