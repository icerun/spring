package com.lxm.spring.springmvctest.config;

import com.lxm.spring.springmvctest.service.UserServce;
import com.lxm.spring.springmvctest.service.impl.MenServiceImpl;
import com.lxm.spring.springmvctest.service.impl.UserServiceImpl;
import com.lxm.spring.springmvctest.service.impl.WomenServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/7 0:22
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.lxm.spring.springmvctest")
public class UserConfig {

	@Bean
	public UserServce getWomenService(){
		return new WomenServiceImpl();
	}

	@Bean
	public UserServce getMenService(){
		return new MenServiceImpl();
	}

	@Bean
	public UserServce getUsersService(){
		return new UserServiceImpl();
	}
}
