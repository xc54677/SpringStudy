package com.springstudy.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfter implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("后置通知：类名: " + target.getClass().getName() + ",方法名:"+method.getName() + ",参数个数:"+args.length + ",返回类型:" + returnValue);
		
	}

}
