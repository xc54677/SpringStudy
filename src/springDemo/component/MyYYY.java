package springDemo.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("myYYY")
public class MyYYY implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //configurableListableBeanFactory.getBeanDefinition("Id") //根据bean的名字(Id)获取bean本身
        int beanCounts = configurableListableBeanFactory.getBeanDefinitionCount(); //获取容器中bean的数量
        System.out.println("{b}容器中bean个数: " + beanCounts);

        String[] beanNames = configurableListableBeanFactory.getBeanDefinitionNames();
        System.out.println("{b}容器中bean名字: " + Arrays.asList(beanNames));
    }
}
