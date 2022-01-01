package com.lxm.spring.handler;

import com.lxm.spring.parser.AuthorBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class AuthorNamespaceHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		registerBeanDefinitionParser("author", new AuthorBeanDefinitionParser());
	}
}
