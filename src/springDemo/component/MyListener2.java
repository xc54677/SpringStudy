package springDemo.component;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener2 {

    //本方法是一个监听方法
    @EventListener(classes = {ApplicationEvent.class})
    public void myListener(ApplicationEvent event){
        System.out.println("=========+++++++++++===========" + event + "=========+++++++++++===========");

    }

}
