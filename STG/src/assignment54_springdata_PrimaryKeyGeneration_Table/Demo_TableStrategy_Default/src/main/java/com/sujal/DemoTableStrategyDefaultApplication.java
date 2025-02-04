package com.sujal;

import java.time.LocalDate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.sujal.dto.CustomerDTO;
import com.sujal.service.CustomerServiceImpl;

@SpringBootApplication
public class DemoTableStrategyDefaultApplication implements CommandLineRunner {
	
	public static final Log LOGGER = LogFactory.getLog(DemoTableStrategyDefaultApplication.class);
	@Autowired
	CustomerServiceImpl customerService;
	
	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(DemoTableStrategyDefaultApplication.class,args);
	
	}
	
	public void run(String... args) throws Exception {
		addCustomer();
	}
	
	public void addCustomer() {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setEmailId("tim@sujal.com");
		customerDTO.setName("Tim");
		customerDTO.setDateOfBirth(LocalDate.now());
		try {
			Integer id = customerService.addCustomer(customerDTO);
			LOGGER.info(environment.getProperty("UserInterface.INSERT_SUCCESS") + id);
		} catch (Exception e) {
		
			if (e.getMessage() != null)
				LOGGER.info(environment.getProperty(e.getMessage(),
								"Something went wrong. Please check log file for more details."));
		}
	
	}

}
