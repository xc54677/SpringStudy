package com.springstudy.entity;

import com.springstudy.factory.CourseFactory;
import com.springstudy.newInstance.ICourse;

public class Student {
	private int stuNo;
	private String stuName;
	private int stuAge;
	
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.stuNo + ", " + this.stuName + ", " + this.stuAge;
	}
	
	public void learnCourse(String name) {
		CourseFactory.getCoutse(name).learn();
	}

}
