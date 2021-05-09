package com.cg.psd.demo1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAOP {

	private static Logger LOGGER = LoggerFactory.getLogger(DemoAOP.class);
	
//	@Before("execution(* com.cg.psd.demo1.controllers.*.*(..))")
//	public void demoAOPBefore(){
//		LOGGER.info("Going demo1 controller");
//	}
//	
//	@After("execution(* com.cg.psd.demo1.controllers.*.*(..))")
//	public void demoAOPAfter(){
//		LOGGER.info("Left demo1 controller");
//	}
	
	@Around("execution(* com.cg.psd.demo1.controllers.*.*(..))")
	public Object demoAOPAround(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("Before method: "+ joinPoint.getSignature().toString());
		Object obj = joinPoint.proceed();
		LOGGER.info("After method: "+ joinPoint.getSignature().toString());
		return obj;
	}
}
