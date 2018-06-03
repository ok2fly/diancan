package com.gcfd.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @类名：Aop.java
* @作者：one
* @时间：2016年7月13日 下午11:40:42
* @版权：pengkaione@icloud.com
* @描述： 
*/
@Aspect
public class SysAop {
	
	private static final Logger logger = LoggerFactory.getLogger(SysAop.class);
	
	public static final String DFEL = "execution(public * com.login.server..*(..))";
	/**
	 * 配置前置通知,使用在方法aspect()上注册的切入点
	 * 同时接受JoinPoint切入点对象,可以没有该参数
	 * @param joinPoint
	 */
	@Before(DFEL)
	public void before(JoinPoint joinPoint){
		logger.debug("----------------------------before---------------------------------------");
		
	}
	
	/**
	 * 配置后置通知,使用在方法aspect()上注册的切入点
	 * @param joinPoint
	 */
	@After(DFEL)
	public void after(JoinPoint joinPoint){
		logger.debug("----------------------------after---------------------------------------");
	}
		
	
	/**
	 * 配置环绕通知,使用在方法aspect()上注册的切入点
	 * @param joinPoint
	 */
	@Around(DFEL)
	public Object around(ProceedingJoinPoint joinPoint){
		long start = System.currentTimeMillis();
		Object result = null;
		try {
			logger.debug("----------------------------around fefoce: {} ---------------------------------------",start);
			result = joinPoint.proceed();
			long end = System.currentTimeMillis();
			logger.debug("---------------------------- around end : {}---------------------------------------",end-start);
		} catch (Throwable e) {
			long end = System.currentTimeMillis();
			logger.debug("----------------------------around : {} 错误信息: {} ---------------------------------------",end-start,e.getMessage());
		}
		return result;
	}
		
	/**
	 * 配置后置返回通知,使用在方法aspect()上注册的切入点
	 * @param joinPoint
	 */
	@AfterReturning(DFEL)
	public void afterReturn(JoinPoint joinPoint){
		logger.debug("----------------------------afterReturn---------------------------------------");
	}
	
	/**
	 * 配置抛出异常后通知,使用在方法aspect()上注册的切入点
	 * @param joinPoint
	 * @param ex
	 */
	@AfterThrowing(pointcut=DFEL, throwing="ex")
	public void afterThrow(JoinPoint joinPoint, Exception ex){
		logger.debug("----------------------------afterThrow---------------------------------------");
	}
}
