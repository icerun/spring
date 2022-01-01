/*
 * Copyright 2002-2014 the original author or authors.
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

package org.springframework.context;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.lang.Nullable;

/**
 * Central interface to provide configuration for an application.
 * 【翻译】为应用程序提供配置的中央接口。
 * This is read-only while the application is running, but may be
 * reloaded if the implementation supports this.
 * 【翻译】当应用程序运行时，这是只读的，但是如果实现支持这一点，则可以重新加载。
 *
 * <p>An ApplicationContext provides:
 * 【翻译】 ApplicationContext 提供了：
 * <ul>
 * <li>Bean factory methods for accessing application components.
 * 		【翻译】 提供了一个访问应用程序组件的 Bean 工厂方法
 * Inherited from {@link org.springframework.beans.factory.ListableBeanFactory}.
 * 		【翻译】 继承于ListableBeanFactory 接口  按住ctrl 点击👆方的包名，可以跳转到该接口，该接口负责
 * <li>The ability to load file resources in a generic fashion.
 * 		【翻译】 以通用方式加载文件资源的能力。
 * Inherited from the {@link org.springframework.core.io.ResourceLoader} interface.
 * 【翻译】集成自{@link org.springframework.core.io.ResourceLoader} 接口
 * <li>The ability to publish events to registered listeners.
 * <li>【翻译】向注册的侦听器发布事件的能力。
 * Inherited from the {@link ApplicationEventPublisher} interface.
 *【翻译】集成自{@link ApplicationEventPublisher} 接口
 * <li>The ability to resolve messages, supporting internationalization.
 * <li>能够解析消息，支持国际化。
 *
 * Inherited from the {@link MessageSource} interface.
 * 【翻译】继承自{@link MessageSource}接口。
 *
 * <li>Inheritance from a parent context. Definitions in a descendant context
 * will always take priority. This means, for example, that a single parent
 * context can be used by an entire web application, while each servlet has
 * its own child context that is independent of that of any other servlet.
 * 【翻译】从父上下文继承。后代上下文中的定义将始终优先。例如，这意味着一个单一的父上下文可以被整个web应用程序使用，而每个servlet都有自己的子上下文，独立于任何其他servlet的子上下文。
 * </ul>
 *
 * <p>In addition to standard {@link org.springframework.beans.factory.BeanFactory}
 * lifecycle capabilities, ApplicationContext implementations detect and invoke
 * {@link ApplicationContextAware} beans as well as {@link ResourceLoaderAware},
 * {@link ApplicationEventPublisherAware} and {@link MessageSourceAware} beans.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see ConfigurableApplicationContext
 * @see org.springframework.beans.factory.BeanFactory
 * @see org.springframework.core.io.ResourceLoader
 */
public interface ApplicationContext extends EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory,
		MessageSource, ApplicationEventPublisher, ResourcePatternResolver {

	/**
	 * Return the unique id of this application context.
	 * 【翻译】返回此应用程序上下文的唯一id。
	 * @return the unique id of the context, or {@code null} if none
	 */
	@Nullable
	String getId();

	/**
	 * Return a name for the deployed application that this context belongs to.
	 * 【翻译】返回此上下文所属的已部署应用程序的名称。
	 * @return a name for the deployed application, or the empty String by default
	 */
	String getApplicationName();

	/**
	 * Return a friendly name for this context.
	 * 【翻译】返回此上下文的友好名称。
	 * @return a display name for this context (never {@code null})
	 */
	String getDisplayName();

	/**
	 * Return the timestamp when this context was first loaded.
	 * 【翻译】返回首次加载此上下文时的时间戳。
	 * @return the timestamp (ms) when this context was first loaded
	 */
	long getStartupDate();

	/**
	 * Return the parent context, or {@code null} if there is no parent
	 * and this is the root of the context hierarchy.
	 * 【翻译】返回父上下文，如果没有父上下文并且这是上下文层次结构的根，则返回{@code null}。
	 * @return the parent context, or {@code null} if there is no parent
	 */
	@Nullable
	ApplicationContext getParent();

	/**
	 * Expose AutowireCapableBeanFactory functionality for this context.
	 * <p>This is not typically used by application code, except for the purpose of
	 * initializing bean instances that live outside of the application context,
	 * applying the Spring bean lifecycle (fully or partly) to them.
	 * 【翻译】为此上下文公开AutowireCapableBeanFactory功能。这通常不由应用程序代码使用，除非是为了初始化位于应用程序上下文之外的bean实例，对它们应用springbean生命周期（全部或部分）。
	 * <p>Alternatively, the internal BeanFactory exposed by the
	 * 【翻译】或者，内部Bean工厂
	 * {@link ConfigurableApplicationContext} interface offers access to the
	 * {@link AutowireCapableBeanFactory} interface too. The present method mainly
	 * serves as a convenient, specific facility on the ApplicationContext interface.
	 * <p><b>NOTE: As of 4.2, this method will consistently throw IllegalStateException
	 * after the application context has been closed.</b> In current Spring Framework
	 * versions, only refreshable application contexts behave that way; as of 4.2,
	 * all application context implementations will be required to comply.
	 * @return the AutowireCapableBeanFactory for this context
	 * @throws IllegalStateException if the context does not support the
	 * {@link AutowireCapableBeanFactory} interface, or does not hold an
	 * autowire-capable bean factory yet (e.g. if {@code refresh()} has
	 * never been called), or if the context has been closed already
	 * @see ConfigurableApplicationContext#refresh()
	 * @see ConfigurableApplicationContext#getBeanFactory()
	 */
	AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException;

}
