package com.lxm.spring.springmvctest.service.impl;

import com.lxm.spring.springmvctest.service.UserServce;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;

import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/7 0:26
 * @Version 1.0
 */
@HandlesTypes(UserServce.class)
public class UserServiceImpl implements UserServce {

	/**
	 * 人会说话
	 *
	 * @param userClasses@return
	 */
	@Override
	public void sayHello(Set<Class<?>> userClasses) {
		List<UserServce> initals = Collections.emptyList();
		if(CollectionUtils.isEmpty(userClasses)){
			initals = new ArrayList<>();
			for (Class<?> userClass : userClasses) {
				try {
					try {
						UserServce userServce = (UserServce) ReflectionUtils.accessibleConstructor(userClass).newInstance();
						initals.add(userServce);
					} catch (InstantiationException e) {
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			}

		}



	}
}
