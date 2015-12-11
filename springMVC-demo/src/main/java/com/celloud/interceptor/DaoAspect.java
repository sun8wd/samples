package com.celloud.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class DaoAspect {
	@Before("execution (* com.celloud.dao.*.*(..))")
	public void before(JoinPoint point) {
		System.out.println("【before】 "+point.toLongString());
	}

	@After("execution (* com.celloud.dao.*.*(..))")
	public void after(JoinPoint point) {
		System.out.println("【after】 "+point.toLongString());
	}

	@AfterThrowing("execution (* com.celloud.dao.*.*(..))")
	public void afterThrowing(JoinPoint point) {
		System.out.println("【afterThrowing】 "+point.toLongString());
	}

	@Around("execution (* com.celloud.dao.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("【around】 before "+joinPoint.toLongString());
		Object object= joinPoint.proceed();
		System.out.println("【around】 after "+joinPoint.toLongString());
		return object;
	}
}
