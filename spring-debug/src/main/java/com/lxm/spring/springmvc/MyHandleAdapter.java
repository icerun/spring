package com.lxm.spring.springmvc;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.LastModified;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/26 22:02
 * @Version 1.0
 */
public class MyHandleAdapter implements HandlerAdapter {
	@Override
	public boolean supports(Object handler) {
		return handler instanceof MyHandleAdapter;
	}


	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return null;
	}

	@Override
	public long getLastModified(HttpServletRequest request, Object handler) {
		return 0;
	}
}
