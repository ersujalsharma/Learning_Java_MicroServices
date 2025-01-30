package com.sujal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.sujal.controller.EmployeeLoginController;
import com.sujal.dto.EmployeeLogin;
import com.sujal.exception.EmployeeAuthenticateException;

@SpringBootApplication
public class DemoSpringBootLoggingApplication implements CommandLineRunner {

	@Autowired
	EmployeeLoginController employeeLoginController;

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootLoggingApplication.class, args);
	}

	@Override
	public void run(String... args) throws EmployeeAuthenticateException {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		try {

			EmployeeLogin customerLogin = new EmployeeLogin();
			customerLogin.setLoginName("tom");
			customerLogin.setPassword("tom123");

			employeeLoginController.authenticateEmployee(customerLogin);
			logger.info(environment.getProperty("SUCCESS"));
		} catch (Exception exception) {
			logger.info(environment.getProperty(exception.getMessage()));
		}

	}

}
