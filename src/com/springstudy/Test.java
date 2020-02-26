package com.springstudy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springstudy.dao.StudentDao;
import com.springstudy.entity.Course;
import com.springstudy.entity.Student;
import com.springstudy.factory.CourseFactory;
import com.springstudy.newInstance.ICourse;
import com.springstudy.service.IStudentService;
import com.springstudy.service.impl.StudentServiceImpl;

public class Test {
	
	public static void createBeanWithIOC() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student2 = (Student) context.getBean("student");
		System.out.println(student2);
	}
	
	public static void learnCourseWithFactory() {
		Student student = new Student();
		student.learnCourse("Html");
		
	}
	
	public static void learnCourseWithFactoryIOC() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student2 = (Student) context.getBean("student");
		student2.learnCourse("Java");
	}
	
	public static void testDI() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Course course = (Course)context.getBean("course");
		course.showInfo();
	}
	
	public static void testZhuJie() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student2 = (Student) context.getBean("student");
		
		/*StudentDao studentDao = (StudentDao) context.getBean("studentDao");
		studentDao.addStudent(student2);*/
		IStudentService studentService = (IStudentService) context.getBean("studentService");
		studentService.addStudent(student2);
	}
	
	public static void testAopBefore() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student2 = (Student) context.getBean("student");
		IStudentService studentService = (IStudentService) context.getBean("studentService");
		studentService.addStudent(student2);
		studentService.deleteStudentByNo(1);
	}
	
	public static void testAopAfter() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student2 = (Student) context.getBean("student");
		IStudentService studentService = (IStudentService) context.getBean("studentService");
		studentService.addStudent(student2);
	}
	
	public static void testAopException() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student2 = (Student) context.getBean("student");
		IStudentService studentService = (IStudentService) context.getBean("studentService");
		studentService.addStudent(student2);
	}
	
	public static void testAopAround() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IStudentService studentService = (IStudentService) context.getBean("studentService");
		studentService.modifyStudentByNo(1);
	}
	
	public static void testAopAnnotation() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IStudentService studentService = (IStudentService) context.getBean("studentService");
		studentService.modifyStudentByName("a");
		
		studentService.modifyStudentByAge(11);
	}
	
	public static void testAopSchema() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IStudentService studentService = (IStudentService) context.getBean("studentService");
		studentService.modifyStudentByNo(1);
	}
	

	public static void main(String[] args) {
		
		testAopSchema();
		
	}

}
