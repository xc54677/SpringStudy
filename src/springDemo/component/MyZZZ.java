package springDemo.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;
import springDemo.entity.Orange;

@Component
public class MyZZZ implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry postProcessBeanDefinitionRegistry) throws BeansException {
        System.out.println("{a}postProcessBeanDefinitionRegistry容器中注册的bean的数量"
                + postProcessBeanDefinitionRegistry.getBeanDefinitionCount());

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Orange.class);//产生BeanDefinition
//        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        postProcessBeanDefinitionRegistry.registerBeanDefinition("myBean",beanDefinitionBuilder.getBeanDefinition());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory postProcessBeanFactory) throws BeansException {
        System.out.println("{a}configurableListableBeanFactory容器中注册的bean的数量");
        Object myBean = postProcessBeanFactory.getBean("myBean");
        System.out.println(myBean.getClass().getName());
    }
}

