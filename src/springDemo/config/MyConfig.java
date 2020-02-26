package springDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springDemo.entity.Adress;
import springDemo.entity.Student;

@Configuration
@ComponentScan(value="springDemo")
public class MyConfig {
	
	@Bean
	public Student student() {
		Student student = new Student(1, "zs", 20);
		student.setAdress(new Adress("Nanjing","Shanghai"));
		return student;
	}

}
