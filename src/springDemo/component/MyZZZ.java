package springDemo.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyZZZ implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry postProcessBeanDefinitionRegistry) throws BeansException {
        System.out.println("{a}postProcessBeanDefinitionRegistry容器中注册的bean的数量"
                + postProcessBeanDefinitionRegistry.getBeanDefinitionCount());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory postProcessBeanFactory) throws BeansException {
        System.out.println("{a}configurableListableBeanFactory容器中注册的bean的数量"
                );
    }
}
