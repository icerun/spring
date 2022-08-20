package com.lxm.spring.factorys.test;

import com.lxm.spring.factorys.service.Car;
import com.lxm.spring.factorys.service.ProductFactory;
import com.lxm.spring.factorys.service.config.CarFactoryConfig;
import com.lxm.spring.factorys.service.impl.AudiFactory;
import com.lxm.spring.factorys.service.impl.BaomaFactory;
import com.lxm.spring.factorys.util.SpringContextUtil;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/22 22:13
 * @Version 1.0
 */
public class FactoryTest {
	public static void main(String[] args) {
//		test2();

		test3();

	}

	public static void test3(){
//		ApplicationContext context = new AnnotationConfigApplicationContext(CarFactoryConfig.class);
		ProductFactory productFactory = SpringContextUtil.getBean(ProductFactory.class);
		Car audi = productFactory.create("audi");
		audi.run();

	}

	public static void test2(){
		ApplicationContext context = new AnnotationConfigApplicationContext(CarFactoryConfig.class);
		AudiFactory audiFactory = context.getBean(AudiFactory.class);
		Car audi = audiFactory.create("audi");
		audi.run();
	}

	public static void test1(){
		ProductFactory productFactory = new AudiFactory();
		Car audi = productFactory.create("audi");
		audi.run();

		ProductFactory productFactory1 = new BaomaFactory();
		Car baoma = productFactory1.create("baoma");
		baoma.run();
	}

}
