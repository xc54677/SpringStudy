package com.springstudy.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAround implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;
		
		System.out.println("环绕通知：类名: " + invocation.getThis()
				+ ",方法名:"+invocation.getMethod().getName() + ",参数个数:"+invocation.getArguments().length 
				+ ", 返回类型:" + invocation.getMethod().getReturnType().getName());
		
		//方法体1
		try {
			//方法体2
			//执行方法体之前的通知 - 前置通知
			System.out.println("[环绕通知]:执行方法的前置通知...........");
			
			result = invocation.proceed();//控制目标方法的执行, result - 目标方法的执行返回值
			
			//执行方法体之后的通知 - 后置通知
			System.out.println("[环绕通知]:执行方法的后置通知...........");
		} catch (Exception e) {
			//方法体3
			//执行方法体异常的通知
			System.out.println("[环绕通知]:执行方法的异常通知..........."+e);
		}
		return result;
	}

}
