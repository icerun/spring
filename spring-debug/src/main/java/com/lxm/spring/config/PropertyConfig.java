package com.lxm.spring.config;

import com.lxm.spring.domain.Person;
import org.springframework.context.annotation.*;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/1 16:45
 * @Version 1.0
 */
@Configuration
//@PropertySource(value = {"classpath:person.properties","classpath:exten.properties"},encoding = "UTF-8")//方式一
@PropertySources(value = {
		@PropertySource(value = "classpath:person.properties", encoding = "UTF-8"),
		@PropertySource(value = "classpath:exten.properties", encoding = "UTF-8")
}
)
@ComponentScan("com.lxm.spring")
public class PropertyConfig {

	@Bean
	public Person person() {
		return new Person();
	}

}
