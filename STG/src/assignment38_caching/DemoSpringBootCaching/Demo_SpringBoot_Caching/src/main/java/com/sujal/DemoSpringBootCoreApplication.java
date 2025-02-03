package com.sujal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;

import com.sujal.dto.CustomerDTO;
import com.sujal.service.CustomerService;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableCaching
public class DemoSpringBootCoreApplication implements CommandLineRunner {

	@Autowired
	CustomerService customerService;

	@Autowired
	Environment environment;

	private static final Log LOGGER = LogFactory.getLog(DemoSpringBootCoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootCoreApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println(LocalDateTime.now());
		getCustomer();
		System.out.println(LocalDateTime.now());
		getCustomer();
		System.out.println(LocalDateTime.now());
		getCustomer();
		System.out.println(LocalDateTime.now());
	}

	public void getCustomer() {
		try {
			CustomerDTO customer = customerService.getCustomerDetails(1);
			LOGGER.info("\n"+customer);
		} catch (Exception e) {
			if (e.getMessage() != null)
				LOGGER.info(environment.getProperty(e.getMessage()));
		}
	}

}
