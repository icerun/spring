package com.lxm.spring.springmvc;

import com.shapesecurity.salvation2.Directive;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/26 22:38
 * @Version 1.0
 */
public class ArrowTest {

	public static final ReflectionUtils.MethodFilter MODEL_ATTRIBUTE_METHODS = method ->
			(!AnnotatedElementUtils.hasAnnotation(method, RequestMapping.class) &&
					AnnotatedElementUtils.hasAnnotation(method, ModelAttribute.class));
	public static void main(String[] args) {
		System.out.println(MODEL_ATTRIBUTE_METHODS);
	}

	@InitBinder
	public static void testMethod(){

	}

}
