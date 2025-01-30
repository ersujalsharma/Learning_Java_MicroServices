package com.sujal;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.sujal.dto.AddressDTO;
import com.sujal.dto.UserDTO;
import com.sujal.exception.UsersException;
import com.sujal.service.UserService;

@SpringBootApplication
public class UserToTraineeApplication implements CommandLineRunner {
	
	@Autowired
	UserService userService;

	@Autowired
	Environment environment;

	private static final Logger LOGGER = LogManager.getLogger(UserToTraineeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UserToTraineeApplication.class, args);
	}

	@Override
	public void run(String... args) throws UsersException {
		addUser();
	}

	public void addUser() {
		try {
			UserDTO userDTO=new UserDTO();
			userDTO.setUserId(1008);
			userDTO.setUserName("James");
			userDTO.setPassword("James@123");
			userDTO.setMobileNumber("3335651233");
			userDTO.setEmail("james@yahoo.in");

			AddressDTO addressDTO=new AddressDTO();
			addressDTO.setDoorNumber("108A");
			addressDTO.setCity("Phoenix");
			addressDTO.setStreet("Fifth Main Street");
			addressDTO.setState("Arizona");
			addressDTO.setZipCode(85003);
			userDTO.setAddress(addressDTO);

			Integer id = userService.addUser(userDTO);
			LOGGER.info("\n"+environment.getProperty("UserInterface.USER_ADDED_SUCCESS") + id);
		} catch (Exception e) {
			LOGGER.info("\n"+environment.getProperty(e.getMessage()));
		}
	}

}
