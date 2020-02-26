package com.springstudy.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAround implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;
		
		System.out.println("����֪ͨ������: " + invocation.getThis()
				+ ",������:"+invocation.getMethod().getName() + ",��������:"+invocation.getArguments().length 
				+ ", ��������:" + invocation.getMethod().getReturnType().getName());
		
		//������1
		try {
			//������2
			//ִ�з�����֮ǰ��֪ͨ - ǰ��֪ͨ
			System.out.println("[����֪ͨ]:ִ�з�����ǰ��֪ͨ...........");
			
			result = invocation.proceed();//����Ŀ�귽����ִ��, result - Ŀ�귽����ִ�з���ֵ
			
			//ִ�з�����֮���֪ͨ - ����֪ͨ
			System.out.println("[����֪ͨ]:ִ�з����ĺ���֪ͨ...........");
		} catch (Exception e) {
			//������3
			//ִ�з������쳣��֪ͨ
			System.out.println("[����֪ͨ]:ִ�з������쳣֪ͨ..........."+e);
		}
		return result;
	}

}
