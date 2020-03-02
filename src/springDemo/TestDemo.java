package springDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import org.springframework.core.env.ConfigurableEnvironment;
import springDemo.config.MyConfig;
import springDemo.entity.Student;

public class TestDemo {
	
	public static void testAnotation() {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        /*ConfigurableEnvironment environment = (ConfigurableEnvironment) context.getEnvironment();
        environment.setActiveProfiles("myApple");

        ((AnnotationConfigApplicationContext) context).register(MyConfig.class);
        ((AnnotationConfigApplicationContext) context).refresh();*/

//		Student student = (Student)context.getBean("stu");
//		System.out.println(student.getAdress());
		
		/*for (String beanName: context.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}*/

//		Object bean = context.getBean("&myFactoryBean");
//		System.out.println(bean);
        /*Object apple = context.getBean("apple");
        Object banana = context.getBean("banana");

        System.out.println(apple);
        System.out.println(banana);*/

        Object myXXX = context.getBean("myXXX");
        System.out.println(myXXX);

        ((AnnotationConfigApplicationContext) context).close();

    }

	public static void main(String[] args) {
		testAnotation();

	}

}
