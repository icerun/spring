package com.lxm.spring.aoptest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/1 17:23
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.lxm.spring.aoptest")
@EnableAspectJAutoProxy(proxyTargetClass = false) //该注解会使用@Import来来导入后置处理器和注册自定义bean来完成aop的功能
public class AopConfig {

}
