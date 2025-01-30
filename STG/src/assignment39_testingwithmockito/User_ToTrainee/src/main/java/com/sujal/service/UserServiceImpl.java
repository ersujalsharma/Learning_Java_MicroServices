package com.sujal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujal.dto.UserDTO;
import com.sujal.exception.UsersException;
import com.sujal.repository.UserRepository;
import com.sujal.validator.Validator;

@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	public Integer addUser(UserDTO  userDTO) throws UsersException {
		Validator.validate(userDTO);
		return userRepository.addUser(userDTO);
	}
}
