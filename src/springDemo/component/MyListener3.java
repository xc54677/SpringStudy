package springDemo.component;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

//@Component
public class MyListener3 extends ApplicationEvent{


    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyListener3(Object source) {
        super(source);
    }
}
