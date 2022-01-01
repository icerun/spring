package com.lxm.spring.resolveBeforeInstantiation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * 功能描述: resolveBeforeInstantiation方法的拓展点
 *
 * @author luxiaomeng
 * @date 2021/7/4 0:07
 * @修改日志：
 */
public class ResolveBeforeInstantiationProcessor implements InstantiationAwareBeanPostProcessor {
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

		return null;
	}

}
