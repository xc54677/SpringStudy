package com.springstudy.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.springstudy.dao.StudentDao;
import com.springstudy.entity.Student;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao{
	
	@Override
	public void addStudent(Student student) {
		System.out.println("增加学生...");
		//throw new RuntimeException("模拟运行时异常！！！");
	}
	
}
