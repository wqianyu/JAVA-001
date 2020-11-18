package io.kaitoshy.parser;


import io.kaitoshy.demo.Student;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;



/**
 * ShardingSphere data source io.kaitoshy.parser for spring namespace.
 */
public final class CustomStudentDefinitionParser extends AbstractSimpleBeanDefinitionParser {

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        Integer id = Integer.valueOf(element.getAttribute("code"));
        String name = element.getAttribute("name");

        builder.addPropertyValue("code", id);
        builder.addPropertyValue("name", name);
    }

    @Override
    protected Class<?> getBeanClass(Element element) {
        return Student.class;
    }
}
