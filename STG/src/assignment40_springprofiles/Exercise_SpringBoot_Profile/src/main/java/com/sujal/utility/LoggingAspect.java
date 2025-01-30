package com.sujal.utility;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	@AfterThrowing(pointcut = "execution(* com.sujal.service.*Impl.*(..))", throwing = "exception")
	public void logServiceException(Exception exception) {
		Logger logger=LoggerFactory.getLogger(this.getClass());
		logger.error(exception.getMessage(),exception);
	}
	
}
