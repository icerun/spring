package com.lxm.spring.config;

import com.lxm.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * 功能描述: 配置类
 * @author luxiaomeng
 * @date  2021/3/12 13:59
 *
 * <p>往IOC容器添加组件的方式
 * 		1：@CompentScan + @Controller + @Service @Respository @compent
 * 		2: 通过Bean的方式来导入组件，适用于第三方组件导入
 * 		3：通过@Import来导入组件（导入组件的id为全类名路径）	@Import(value = {User.class})
 * 		4：通过实现FactoryBean接口来注册组件
 *
 * @修改日志：
 */
//@ComponentScan(basePackages = {"com.lxm.spring.domain"},excludeFilters = {})
//@PropertySource(value = {"classpath:person.properties"}) //指定外部文件的位置
//@Import(value = {User.class})
@Configuration
//@ComponentScan(basePackages =  {"com.lxm.spring.service","com.lxm.spring.listener"})
//@ComponentScan(basePackages =  {"com.lxm.spring.processer"})
//@ComponentScan(basePackages =  {"com.lxm.spring.domain"})
//@ComponentScan(basePackages =  {"com.lxm.spring.service","com.lxm.spring.processer"})
@ComponentScan(basePackages =  {"com.lxm.spring.service"})
// 开启AOP
@EnableAspectJAutoProxy
public class MyConfig {
	/*自动装配:
		@Resource(JSR250规范)
		@Autowired
		@InJect（JSR330规范） 需要导入依赖包
	 */

	/**
	 * 功能描述:@Autowired自动装配首先时按照类型进行装配，若在IOC容器中发现了多个相同类型的组件，那么就按照 属性名称来进行装配
	 * 		假设我们需要指定特定的组件来进行装配，我们可以通过使用@Qualifier("user")来指定装配的组件或者在配置类上的@Bean加上@Primary注解
	 * 	假设我们容器中即没有user,那么在装配的时候就会抛出异常,不想抛出异常可以为false
	 */
//	@Autowired // 可以在set方法上 构造  入参
//	private User user;


//	@Lazy
	// 满足条件才会被实例化
//	@Conditional(value = MyCondition.class)
//	@Bean
	// 什么环境才会生效
//	@Profile(value = "dev")
//	@Scope(value = "singleton")
//	public User user() {
//		return new User();
//	}
//	@Bean(name = "user02")
//	public User user02() {
//		User user = new User();
//		user.setName("sdfsdfsdf");
//		return user;
//	}
}
