package com.lxm.spring.parser;

import com.lxm.spring.domain.Author;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class AuthorBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
	@Override
	protected Class<?> getBeanClass(Element element) {
		return Author.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String username = element.getAttribute("username");
		String sex = element.getAttribute("sex");
		if (StringUtils.hasText(username)) {
			builder.addPropertyValue("username",username);
		}
		if (StringUtils.hasText(sex)) {
			builder.addPropertyValue("sex",username);
		}
	}
}
