package com.springstudy.service;

import com.springstudy.entity.Student;

public interface IStudentService {
	
	void addStudent(Student student);
	void deleteStudentByNo(int number);
	void modifyStudentByNo(int number);
	void modifyStudentByName(String name);
	void modifyStudentByAge(int age);

}
