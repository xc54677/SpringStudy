package com.springstudy.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springstudy.newInstance.HtmlCourse;
import com.springstudy.newInstance.ICourse;
import com.springstudy.newInstance.JavaCourse;

public class CourseFactory {
	
	public static ICourse getCoutse(String name) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		if (name.equals("Java")) {
			return (ICourse) context.getBean("javaCourse");
		}else {
			return (ICourse) context.getBean("htmlCourse");
		}
		
	}

}
