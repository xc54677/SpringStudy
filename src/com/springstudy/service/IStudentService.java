package com.springstudy.service;

import com.springstudy.entity.Student;

public interface IStudentService {
	
	void addStudent(Student student);
	void deleteStudentByNo(int number);

}
