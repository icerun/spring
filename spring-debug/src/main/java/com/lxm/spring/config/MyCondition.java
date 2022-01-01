package com.lxm.spring.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 功能描述: 条件判断
 * @author luxiaomeng
 * @date  2021/3/12 13:57
 * @修改日志：
 */
public class MyCondition implements Condition
{
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		if (context.getBeanFactory().containsBean("xxxx")) {
			return true;
		}
		return false;
	}
}
