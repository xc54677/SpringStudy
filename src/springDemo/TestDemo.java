package springDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import springDemo.config.MyConfig;
import springDemo.entity.Student;

public class TestDemo {
	
	public static void testAnotation() {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//		Student student = (Student)context.getBean("stu");
//		System.out.println(student.getAdress());
		
		for (String beanName: context.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
		
	}

	public static void main(String[] args) {
		testAnotation();

	}

}
