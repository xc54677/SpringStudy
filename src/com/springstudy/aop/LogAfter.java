package com.springstudy.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfter implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("����֪ͨ������: " + target.getClass().getName() + ",������:"+method.getName() + ",��������:"+args.length + ",��������:" + returnValue);
		
	}

}
