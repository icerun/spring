//package com.lxm.spring.exceptions;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//
///**
// * @Description
// * @Author shenshixi
// * @Date 2022/2/14 21:09
// * @Version 1.0
// */
//@Aspect
//@Component
//public class ResultAspect {
//
//	@Around("@annotation(ResultHandler)")
//	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//		Object proceed = null;
//		try {
//			proceed = joinPoint.proceed();
//		} catch (ConstraintViolationException exception) {
//			exception.getMessage();
//		} catch (Exception e) {
//			e.getMessage();
//		}
//		return proceed;
//	}
//}
