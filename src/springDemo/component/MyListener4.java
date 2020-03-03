package springDemo.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.AbstractApplicationContext;

//@Component
public class MyListener4 extends AbstractApplicationContext {

    @Override
    public void registerShutdownHook() {
        super.registerShutdownHook();
    }

    @Override
    protected void refreshBeanFactory() throws BeansException, IllegalStateException {

    }

    @Override
    protected void closeBeanFactory() {

    }

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
        return null;
    }
}
