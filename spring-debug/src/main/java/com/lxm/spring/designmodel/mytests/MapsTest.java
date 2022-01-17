package com.lxm.spring.designmodel.mytests;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/16 21:16
 * @Version 1.0
 */
public class MapsTest {
	public static void main(String[] args) {
		ConcurrentMap<Object, Object> concurrentMap = Maps.newConcurrentMap();

		Objects.isNull(concurrentMap);
		Objects.nonNull(concurrentMap);

		ObjectUtils.isEmpty(concurrentMap);

		StringUtils.isEmpty("");
		int kk = StringUtils.length("kk");


	}

}
