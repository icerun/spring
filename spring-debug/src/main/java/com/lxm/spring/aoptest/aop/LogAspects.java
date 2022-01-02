package com.lxm.spring.aoptest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/1 17:30
 * @Version 1.0
 */
@Aspect
@Component
public class LogAspects {

	/**
	 * 声明切点 表示切到com.lxm.spring.service.MathCalculator类中所有方法中
	 */
	@Pointcut("execution(public int com.lxm.spring.aoptest.service.MathCalculator.*(..))")
	public void pointCut() {

	}

	/**
	 * 环绕通知
	 *
	 * @param joinPoint
	 * @return
	 */
	/**
	 * 环绕通知
	 */
	@Around("pointCut()")
	public Object doAround(ProceedingJoinPoint pjp) {
		// 获取被增强的目标对象，然后获取目标对象的class
		Class<?> targetClass = pjp.getTarget().getClass();
		System.out.println("执行Around，被增强的目标类为：" + targetClass);
		// 方法名称
		String methodName = pjp.getSignature().getName();
		System.out.println("执行Around，目标方法名称为：" + methodName);
		// 目标方法的参数类型
		// 目标方法的入参
		Object[] args = pjp.getArgs();
		System.out.println("执行Around，方法入参为：" + Arrays.toString(args));
		try {
			// 目标方法
//			Method method = targetClass.getMethod(methodName, ((MethodSignature) pjp.getSignature()).getParameterTypes());
//			System.out.println("执行Around，方法为：" + method);
			// 继续放行
			return pjp.proceed();
		} catch (Throwable e) {
			System.err.println("执行Around异常..." + e);
			return "error";
		}
	}

}
