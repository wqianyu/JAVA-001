package io.kaitoshy.handler;


import io.kaitoshy.parser.CustomKlassDefinitionParser;
import io.kaitoshy.parser.CustomStudentDefinitionParser;
import io.kaitoshy.tag.CustomKlassBeanDefinitionTag;
import io.kaitoshy.tag.CustomStudentBeanDefinitionTag;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Spring namespace io.kaitoshy.handler for data source.
 */
public final class CustomNamespaceHandler extends NamespaceHandlerSupport {
    
    @Override
    public void init() {
        registerBeanDefinitionParser(CustomStudentBeanDefinitionTag.ROOT_TAG, new CustomStudentDefinitionParser());
        registerBeanDefinitionParser(CustomKlassBeanDefinitionTag.ROOT_TAG, new CustomKlassDefinitionParser());
    }
}
