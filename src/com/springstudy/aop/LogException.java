package com.springstudy.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class LogException implements ThrowsAdvice{
	
	public void afterThrowing(Method method, Object[] args, Object target, Throwable ex) {
		System.out.println("异常通知：类名: " + target.getClass().getName() 
				+ ",方法名:"+method.getName() + ",参数个数:"+args.length 
				+ ", 异常类型:" + ex);
	}

}
