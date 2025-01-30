package com.sujal;

import com.sujal.dto.AddressDTO;
import com.sujal.dto.UserDTO;
import com.sujal.exception.UsersException;
import com.sujal.repository.UserRepository;
import com.sujal.service.UserService;
import com.sujal.service.UserServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserToTraineeApplicationTests {
	@Mock
	UserRepository userRepository;
	@InjectMocks
	UserService userService=new UserServiceImpl();
	@Test
	void addUserValidTest() throws UsersException {
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
		Mockito.when(userRepository.addUser(userDTO)).thenReturn(userDTO.getUserId());
		Assertions.assertEquals(userService.addUser(userDTO), userDTO.getUserId());
	}
	@Test
	void addUserInvalidUserNameTest() throws UsersException {
		UserDTO userDTO=new UserDTO();
		userDTO.setUserId(1008);
		userDTO.setUserName("James8");
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
		Exception exception = Assertions.assertThrows(UsersException.class, ()->userService.addUser(userDTO));
		Assertions.assertEquals(exception.getMessage(), "Validator.INVALID_USERNAME");
	}
	@Test
	void addUserInvalidPasswordTest() throws UsersException {
		UserDTO userDTO=new UserDTO();
		userDTO.setUserId(1008);
		userDTO.setUserName("James");
		userDTO.setPassword("Ja23");
		userDTO.setMobileNumber("3335651233");
		userDTO.setEmail("james@yahoo.in");

		AddressDTO addressDTO=new AddressDTO();
		addressDTO.setDoorNumber("108A");
		addressDTO.setCity("Phoenix");
		addressDTO.setStreet("Fifth Main Street");
		addressDTO.setState("Arizona");
		addressDTO.setZipCode(85003);
		userDTO.setAddress(addressDTO);
		Exception exception = Assertions.assertThrows(UsersException.class, ()->userService.addUser(userDTO));
		Assertions.assertEquals(exception.getMessage(), "Validator.INVALID_PASSWORD");
	}
	@Test
	void addUserInvalidEmailTest() throws UsersException {
		UserDTO userDTO=new UserDTO();
		userDTO.setUserId(1008);
		userDTO.setUserName("James");
		userDTO.setPassword("James@123");
		userDTO.setMobileNumber("3335651233");
		userDTO.setEmail("james@yahoo");

		AddressDTO addressDTO=new AddressDTO();
		addressDTO.setDoorNumber("108A");
		addressDTO.setCity("Phoenix");
		addressDTO.setStreet("Fifth Main Street");
		addressDTO.setState("Arizona");
		addressDTO.setZipCode(85003);
		userDTO.setAddress(addressDTO);
		Exception exception = Assertions.assertThrows(UsersException.class, ()->userService.addUser(userDTO));
		Assertions.assertEquals(exception.getMessage(), "Validator.INVALID_EMAIL");
	}
	@Test
	void addUserInvalidMobileNumberTest() throws UsersException {
		UserDTO userDTO=new UserDTO();
		userDTO.setUserId(1008);
		userDTO.setUserName("James");
		userDTO.setPassword("James@123");
		userDTO.setMobileNumber("333565123");
		userDTO.setEmail("james@yahoo.in");

		AddressDTO addressDTO=new AddressDTO();
		addressDTO.setDoorNumber("108A");
		addressDTO.setCity("Phoenix");
		addressDTO.setStreet("Fifth Main Street");
		addressDTO.setState("Arizona");
		addressDTO.setZipCode(85003);
		userDTO.setAddress(addressDTO);
		Exception exception = Assertions.assertThrows(UsersException.class, ()->userService.addUser(userDTO));
		Assertions.assertEquals(exception.getMessage(), "Validator.INVALID_MOBILENO");
	}
	@Test
	void addUserInvalidAddressTest() throws UsersException {
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
		addressDTO.setZipCode(850093);
		userDTO.setAddress(addressDTO);
		Exception exception = Assertions.assertThrows(UsersException.class, ()->userService.addUser(userDTO));
		Assertions.assertEquals(exception.getMessage(), "Validator.INVALID_ADDRESS");
	}

}