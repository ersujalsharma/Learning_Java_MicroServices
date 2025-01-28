package com.sujal.utility;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggingAspect {
	@Autowired
	Environment environment;

	private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);
	@AfterThrowing(pointcut = "execution(* com.sujal.repository.MovieRepositoryImpl.*(..))", throwing = "exception")
	public void logRepositoryException(Exception exception) {
		LOGGER.error(exception.getMessage());
	}
	@AfterThrowing(pointcut = "execution(* com.sujal.service.MovieServiceImpl.*(..))", throwing = "exception")
	public void logServiceException(Exception exception) {
		LOGGER.error(exception.getMessage());
	}

}