package com.springstudy.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBefore implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Ç°ÖÃÍ¨Öª");
		
	}

}
