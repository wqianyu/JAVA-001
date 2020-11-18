package io.kaitoshy.parser;

import io.kaitoshy.demo.Klass;
import io.kaitoshy.demo.Student;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.Properties;

/**
 * @author kaito
 * @createDate 2020/11/18 17:06
 */
public class CustomKlassDefinitionParser extends AbstractSimpleBeanDefinitionParser {

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String s = element.getNamespaceURI();
        NodeList list = element.getElementsByTagName("*");
        Element propsElement = DomUtils.getChildElementByTagName(element, "list");
        System.out.println(s);
    }



}
