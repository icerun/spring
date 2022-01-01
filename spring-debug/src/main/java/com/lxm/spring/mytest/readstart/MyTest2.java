package com.lxm.spring.mytest.readstart;

import com.lxm.spring.config.MyConfig;
import com.lxm.spring.domain.MyFactoryBean;
import com.lxm.spring.domain.User;
import com.lxm.spring.service.AService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 功能描述: 源码阅读入口2
 * @author luxiaomeng
 * @date  2021/3/12 13:49
 * @修改日志：
 */
public class MyTest2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
		 // 设置环境还可以使用 jvm参数-Dspring.profiles.active=test|dev|prod
		//		ctx.getEnvironment().setActiveProfiles("test", "dev");
//		ctx.publishEvent(new ApplicationEvent("手动发布事件") {
//			@Override
//			public Object getSource() {
//				return super.getSource();
//			}
//		});MyFactoryBean
//		AService user = ctx.getBean("aService", AService.class);
		Object obj = ctx.getBean("aService");
		System.out.println(obj.toString());
	}
}
