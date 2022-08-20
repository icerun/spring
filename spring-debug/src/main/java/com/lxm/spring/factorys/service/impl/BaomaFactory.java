package com.lxm.spring.factorys.service.impl;

import com.lxm.spring.factorys.service.Car;
import com.lxm.spring.factorys.service.ProductFactory;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/23 16:29
 * @Version 1.0
 */
@Service
public class BaomaFactory implements ProductFactory {

	/**
	 * 工厂造车
	 *
	 * @param type
	 * @return
	 */
	@Override
	public Car create(String type) {
		if(!"baoma".equals(type)){
			return null;
		}
		return new BaomaCar();
	}
}
