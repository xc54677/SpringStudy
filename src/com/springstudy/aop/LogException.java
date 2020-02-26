package com.springstudy.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class LogException implements ThrowsAdvice{
	
	public void afterThrowing(Method method, Object[] args, Object target, Throwable ex) {
		System.out.println("�쳣֪ͨ������: " + target.getClass().getName() 
				+ ",������:"+method.getName() + ",��������:"+args.length 
				+ ", �쳣����:" + ex);
	}

}
