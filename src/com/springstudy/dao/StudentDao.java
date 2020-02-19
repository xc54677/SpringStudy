package com.springstudy.dao;

import org.springframework.stereotype.Repository;

import com.springstudy.entity.Student;

public interface StudentDao{
	void addStudent(Student student);
}
