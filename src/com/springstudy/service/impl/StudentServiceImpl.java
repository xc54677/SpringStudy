package com.springstudy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springstudy.dao.StudentDao;
import com.springstudy.dao.impl.StudentDaoImpl;
import com.springstudy.entity.Student;
import com.springstudy.service.IStudentService;

/*@Service("studentService")*/
public class StudentServiceImpl implements IStudentService{
	/*@Autowired
	@Qualifier("studentDao")*/
	private StudentDaoImpl studentDao;

	//@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void addStudent(Student student) {
		
		if (studentDao==null) {
			System.out.println("YES");
		}
		
		studentDao.addStudent(student);
	}

	public void setStudentDao(StudentDaoImpl studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public void deleteStudentByNo(int number) {
		System.out.println("����ѧ��ɾ��ѧ��.....");
		
	}

	@Override
	public void modifyStudentByNo(int number) {
		System.out.println("����ѧ���޸�ѧ��.....");
	}

	@Override
	public void modifyStudentByName(String name) {
		System.out.println("���������޸�ѧ��.....");
	}

	@Override
	public void modifyStudentByAge(int age) {
		System.out.println("���������޸�ѧ��.....");
//		throw new NullPointerException("kong");
		throw new RuntimeException("��������ʱ�쳣");
	}

}
