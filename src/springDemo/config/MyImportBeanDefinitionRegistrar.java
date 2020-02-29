package springDemo.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import springDemo.entity.Orange;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

//        BeanDefinition beanDefinition = new RootBeanDefinition(Orange.class);
        BeanDefinition beanDefinition = new RootBeanDefinition("springDemo.entity.Orange");
        registry.registerBeanDefinition("myOrange",beanDefinition);
    }
}
