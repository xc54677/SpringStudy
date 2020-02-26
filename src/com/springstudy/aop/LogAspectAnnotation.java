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
	
	@Before(value = "execution(public void modifyStudentByName(java.lang.String))") //属性 - 定义切点
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("注解前置通知：类名: " + joinPoint.getTarget().getClass().getName()
		+ ",方法名:"+joinPoint.getSignature().getName() + 
		",参数个数:"+joinPoint.getArgs().length);

		System.out.println("<注解形式前置通知...........>");
	}
	
	@AfterReturning(pointcut = "execution(public void modifyStudentByName(java.lang.String))", 
			returning = "returningValue") //属性 - 定义切点
	public void myAfter(JoinPoint joinPoint, Object returningValue) {
		System.out.println("注解后置通知：类名: " + joinPoint.getTarget().getClass().getName()
				+ ",方法名:"+joinPoint.getSignature().getName() + 
				",参数个数:"+joinPoint.getArgs().length 
				+ ",返回类型：" + returningValue);
		System.out.println("<注解形式后置通知...........>");
	}
	
	//异常通知
	/**
	 * 
	 * @param joinPoint
	 * 如果想 捕获指定类型的异常，可以通过第二个参数实现
	 */
	@AfterThrowing(pointcut="execution(public void modifyStudentByAge(int))",throwing="ne")
	public void myException(JoinPoint joinPoint, NullPointerException ne) {
		System.out.println("<注解形式异常通知...........>"+ ne.getMessage());
	}
	
	//环绕通知
	@Around(value="execution(public void modifyStudentByName(java.lang.String))")
	public void myAround(ProceedingJoinPoint joinPoint) {
		//方法执行前：前置通知
		System.out.println("<注解形式环绕通知.......前置通知>");
		try {
			//方法执行时
			joinPoint.proceed();
			//方法执行后：后置通知
			System.out.println("<注解形式环绕通知.......后置通知>");
		} catch (Throwable e) {
			//发生异常时
			System.out.println("<注解形式环绕通知.......异常通知>");
		}finally {
			//最终通知
			System.out.println("<注解形式环绕通知.......最终通知>");
		}
	}
	
	//最终通知
	@After(value="execution(public void modifyStudentByName(java.lang.String))")
	public void myAfterFinal() {
		System.out.println("<注解形式【最终】通知...........>");
	}

}
