package com.springstudy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import oracle.net.aso.e;

@Component("logAspectAnnotation")
@Aspect
public class LogAspectAnnotation {
	
	@Before(value = "execution(public void modifyStudentByName(java.lang.String))") //���� - �����е�
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("ע��ǰ��֪ͨ������: " + joinPoint.getTarget().getClass().getName()
		+ ",������:"+joinPoint.getSignature().getName() + 
		",��������:"+joinPoint.getArgs().length);

		System.out.println("<ע����ʽǰ��֪ͨ...........>");
	}
	
	@AfterReturning(pointcut = "execution(public void modifyStudentByName(java.lang.String))", 
			returning = "returningValue") //���� - �����е�
	public void myAfter(JoinPoint joinPoint, Object returningValue) {
		System.out.println("ע�����֪ͨ������: " + joinPoint.getTarget().getClass().getName()
				+ ",������:"+joinPoint.getSignature().getName() + 
				",��������:"+joinPoint.getArgs().length 
				+ ",�������ͣ�" + returningValue);
		System.out.println("<ע����ʽ����֪ͨ...........>");
	}
	
	//�쳣֪ͨ
	/**
	 * 
	 * @param joinPoint
	 * ����� ����ָ�����͵��쳣������ͨ���ڶ�������ʵ��
	 */
	@AfterThrowing(pointcut="execution(public void modifyStudentByAge(int))",throwing="ne")
	public void myException(JoinPoint joinPoint, NullPointerException ne) {
		System.out.println("<ע����ʽ�쳣֪ͨ...........>"+ ne.getMessage());
	}
	
	//����֪ͨ
	@Around(value="execution(public void modifyStudentByName(java.lang.String))")
	public void myAround(ProceedingJoinPoint joinPoint) {
		//����ִ��ǰ��ǰ��֪ͨ
		System.out.println("<ע����ʽ����֪ͨ.......ǰ��֪ͨ>");
		try {
			//����ִ��ʱ
			joinPoint.proceed();
			//����ִ�к󣺺���֪ͨ
			System.out.println("<ע����ʽ����֪ͨ.......����֪ͨ>");
		} catch (Throwable e) {
			//�����쳣ʱ
			System.out.println("<ע����ʽ����֪ͨ.......�쳣֪ͨ>");
		}finally {
			//����֪ͨ
			System.out.println("<ע����ʽ����֪ͨ.......����֪ͨ>");
		}
	}
	
	//����֪ͨ
	@After(value="execution(public void modifyStudentByName(java.lang.String))")
	public void myAfterFinal() {
		System.out.println("<ע����ʽ�����ա�֪ͨ...........>");
	}

}
