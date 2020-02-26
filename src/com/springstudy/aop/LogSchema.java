package com.springstudy.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogSchema {
	
	public void before(JoinPoint joinPoint) throws Throwable {
		System.out.println("【基于Schema】前置通知");
		
	}
	
	public void afterReturning(JoinPoint joinPoint, Object returningValue) {
		System.out.println("【基于Schema】后置通知：类名: " + joinPoint.getTarget().getClass().getName()
				+ ",方法名:"+joinPoint.getSignature().getName() + 
				",参数个数:"+joinPoint.getArgs().length
				+ ",返回类型：" + returningValue);
		
	}
	
	public void myException(JoinPoint joinPoint, NullPointerException ne) {
		System.out.println("<【基于Schema】异常通知...........>"+ ne.getMessage());
	}
	
	public void myAround(ProceedingJoinPoint joinPoint) {
		//方法执行前：前置通知
		System.out.println("<【基于Schema】环绕通知.......前置通知>");
		try {
			//方法执行时
			joinPoint.proceed();
			//方法执行后：后置通知
			System.out.println("<【基于Schema】环绕通知.......后置通知>");
		} catch (Throwable e) {
			//发生异常时
			System.out.println("<【基于Schema】环绕通知.......异常通知>");
		}finally {
			//最终通知
			System.out.println("<【基于Schema】环绕通知.......最终通知>");
		}
	}

}
