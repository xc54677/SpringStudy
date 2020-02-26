package springDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import springDemo.entity.Adress;
import springDemo.entity.Student;

@Configuration
@ComponentScan(value="springDemo", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class, Repository.class})})
public class MyConfig {
	
	@Bean
	public Student student() {
		Student student = new Student(1, "zs", 20);
		student.setAdress(new Adress("Nanjing","Shanghai"));
		return student;
	}

}
