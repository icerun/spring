/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**autowired默认按类型注入，可以使用@Qualifier注解实现按名称注入
 *
 * Marks a constructor, field, setter method, or config method as to be autowired by
 * Spring's dependency injection facilities. This is an alternative to the JSR-330
 * {@link javax.inject.Inject} annotation, adding required-vs-optional semantics.
 * 【翻译】 将构造函数，字段，setter方法或config方法标记为由Spring的依赖项注入工具自动装配。这是JSR-330 {@link javax.inject.Inject}注释的替代方法，添加了required-vs-optional语义。
 *
 * <h3>Autowired Constructors</h3>
 * 【翻译】<h3>注入构造方法</h3>
 * <p>Only one constructor of any given bean class may declare this annotation with the {@link #required} attribute set to {@code true}, indicating <i>the</i> constructor
 * <p>任何给定bean类的构造函数都只能使用required属性设置为{@code true}来声明此批注，指示将<i> <i>构造函数用作Spring bean时可以自动装配。
 *
 * Furthermore, if the {@code required} attribute is set to {@code true}, only a single constructor may be annotated with {@code @Autowired}.
 * 此外，如果{@code required}属性设置为{@code true}，则只能使用{@code @Autowired}注释单个构造函数。 *
 *  If multiple <i>non-required</i> constructors declare the annotation, they will be considered as candidates for autowiring.
 *  如果多个<i>non-required<i>构造函数声明了注释，则它们将被视为自动装配的候选对象。
 *
 * The constructor with the greatest number of dependencies that can be satisfied by matching beans in the Spring container will be chosen.
 * 将选择通过匹配Spring容器中的bean可以满足的依赖项数量最多的构造函数。
 *  If none of the candidates can be satisfied, then a primary/default constructor (if present) will be used.
 *  如果所有候选者不能满足，则将使用主要或默认的构造方法
 *  Similarly, if a class declares multiple constructors but none of them is annotated with {@code @Autowired}, then a primary/default constructor (if present) will be used.
 *  同样，如果一个类声明了多个构造函数，但没有一个用{@code @Autowired}进行注释，则将使用主要或默认的构造方法（如果存在）。 *
 *
 * If a class only declares a single constructor to begin with, it will always be used, even if not annotated. An annotated constructor does not have to be public.
 * 如果一个类仅声明一个单一的构造函数开始，即使没有注释，也将始终使用它。带注释的构造函数不必是公共的。 *
 *
 * <h3>Autowired Fields</h3>
 * <h3>注解字段</h3>
 * <p>Fields are injected right after construction of a bean, before any config methods are invoked. Such a config field does not have to be public.
 *在构造任何bean之后，调用任何config方法之前，都将立即注入字段。这样的配置字段不必是公共的。 *
 *
 * <h3>Autowired Methods</h3>
 * <h3>注入方法</h3>
 * <p>Config methods may have an arbitrary name and any number of arguments; each of those arguments will be autowired with a matching bean in the Spring container.
 * <p>Config方法可以具有任意名称和任意数量的参数。这些参数中的每个参数都将与Spring容器中的匹配bean自动注入。 *
 * Bean property setter methods are effectively just a special case of such a general config method. Such config methods do not have to be public.
 * Bean属性设置器方法实际上只是这种常规config方法的特例。这样的配置方法不必是公共的。 *
 *
 * <h3>Autowired Parameters</h3>
 * <h3>注入参数</h3>
 * <p>Although {@code @Autowired} can technically be declared on individual method or constructor parameters since Spring Framework 5.0, most parts of the framework ignore such declarations.
 * <p>尽管从Spring Framework 5.0开始，从技术上讲，{@code @Autowired}可以在单个方法或构造函数参数上声明，但是框架的大多数部分都忽略了此类声明。 *
 *
 *  The only part of the core Spring Framework that actively supports autowired parameters is the JUnit Jupiter support in
 *  积极支持自动装配参数的核心Spring框架的唯一部分是JUnit Jupiter在以下方面的支持：
 *
 * the {@code spring-test} module (see the
 * <a href="https://docs.spring.io/spring/docs/current/spring-framework-reference/testing.html#testcontext-junit-jupiter-di">TestContext framework</a>
 * reference documentation for details).
 *
 * <h3>Multiple Arguments and 'required' Semantics</h3>
 * <h3>多个参数和“必选”语义</h3>
 * <p>In the case of a multi-arg constructor or method, the {@link #required} attribute is applicable to all arguments.
 * <p>对于多参数构造函数或方法，required属性适用于所有参数
 *  Individual parameters may be declared as Java-8 style {@link java.util.Optional} or, as of Spring Framework 5.0, also as {@code @Nullable} or a not-null parameter type in Kotlin, overriding the base 'required' semantics.
 *  各个参数可以声明为Java-8样式的{@link java.util.Optional}，或者从Spring Framework 5.0开始，也可以声明为{@code @Nullable}或Kotlin中的非空参数类型，覆盖必需的基数的语义。 *
 *
 *
 * <h3>Autowiring Arrays, Collections, and Maps</h3>
 * <h3>自动装配数组，集合和map</h3>
 * <p>In case of an array, {@link java.util.Collection}, or {@link java.util.Map} dependency type, the container autowires all beans matching the declared value type.
 * <p>如果是数组，{@ link java.util.Collection}或{@link java.util.Map}依赖类型，则容器将自动装配与声明的值类型匹配的所有bean。 *
 *
 * For such purposes, the map keys must be declared as type {@code String} which will be resolved to the corresponding bean names.
 * 为此，映射键必须声明为{@code String}类型，它将解析为相应的bean名称。
 *  考虑到这样的情况，将订购这种容器提供的收藏品
 *
 * {@link org.springframework.core.Ordered Ordered} and {@link org.springframework.core.annotation.Order @Order} values of the target components, otherwise following their registration order in the container.
 * 目标组件的{@link org.springframework.core.Ordered Ordered}和{@link org.springframework.core.annotation.Order @Order}值，否则遵循其在容器中的注册顺序。 *
 *
 * Alternatively, a single matching target bean may also be a generally typed {@code Collection} or {@code Map} itself, getting injected as such.
 * 或者，单个匹配的目标bean也可以是通常键入的{@code Collection}或{@code Map}本身，就这样注入。 *
 *
 * <h3>Not supported in {@code BeanPostProcessor} or {@code BeanFactoryPostProcessor}</h3>
 * <h3>{@code BeanPostProcessor}或{@code BeanFactoryPostProcessor}不支持</h3>
 * <p>Note that actual injection is performed through a {@link org.springframework.beans.factory.config.BeanPostProcessor } which in turn means that you <em>cannot</em> use {@code @Autowired} to inject references into {@link org.springframework.beans.factory.config.BeanPostProcessor} or {@link org.springframework.beans.factory.config.BeanFactoryPostProcessor} types.
 * <p>请注意，实际注入是通过{@link org.springframework.beans.factory.config.BeanPostProcessor}执行的，这反过来意味着您<em>不能<em>使用{@code @Autowired}将引用注入到{@link org.springframework.beans.factory.config.BeanPostProcessor}或{@link org.springframework.beans.factory.config.BeanFactoryPostProcessor}类型。 *
 *
 *
 *  Please consult the javadoc for the {@link AutowiredAnnotationBeanPostProcessor}  class (which, by default, checks for the presence of this annotation).
 *  请咨询{@link AutowiredAnnotationBeanPostProcessor}类的javadoc（默认情况下，该类检查此注释的存在）。 *
 *
 * 【解析】总结：
 * 1. @Autowired什么时候注入？
 * 项目启动后调用容器的refresh()方法，当运行完finishBeanFactoryInitialization()后完成的注入。
 * 2. @Autowired怎么注入？
 * 从容器中获取到需要注入的实例，使用反射完成的注入
 * 3.运行流程？
 * 循环注册每个bean的时候，会看这个bean是否有需要依赖注入的属性，如果有则从容器中获取到需要注入的属性，然后通过反射进行赋值。
 *
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Sam Brannen
 * @since 2.5
 * @see AutowiredAnnotationBeanPostProcessor
 * @see Qualifier
 * @see Value
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

	/**
	 * Declares whether the annotated dependency is required.
	 * 声明是否需要带注释的依赖项。
	 * <p>Defaults to {@code true}.
	 */
	boolean required() default true;

}
