package com.springstudy.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogSchema {
	
	public void before(JoinPoint joinPoint) throws Throwable {
		System.out.println("������Schema��ǰ��֪ͨ");
		
	}
	
	public void afterReturning(JoinPoint joinPoint, Object returningValue) {
		System.out.println("������Schema������֪ͨ������: " + joinPoint.getTarget().getClass().getName()
				+ ",������:"+joinPoint.getSignature().getName() + 
				",��������:"+joinPoint.getArgs().length
				+ ",�������ͣ�" + returningValue);
		
	}
	
	public void myException(JoinPoint joinPoint, NullPointerException ne) {
		System.out.println("<������Schema���쳣֪ͨ...........>"+ ne.getMessage());
	}
	
	public void myAround(ProceedingJoinPoint joinPoint) {
		//����ִ��ǰ��ǰ��֪ͨ
		System.out.println("<������Schema������֪ͨ.......ǰ��֪ͨ>");
		try {
			//����ִ��ʱ
			joinPoint.proceed();
			//����ִ�к󣺺���֪ͨ
			System.out.println("<������Schema������֪ͨ.......����֪ͨ>");
		} catch (Throwable e) {
			//�����쳣ʱ
			System.out.println("<������Schema������֪ͨ.......�쳣֪ͨ>");
		}finally {
			//����֪ͨ
			System.out.println("<������Schema������֪ͨ.......����֪ͨ>");
		}
	}

}
