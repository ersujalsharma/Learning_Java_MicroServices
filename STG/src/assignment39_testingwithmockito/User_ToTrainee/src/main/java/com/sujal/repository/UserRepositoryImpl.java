package com.sujal.repository;

import org.springframework.stereotype.Repository;

import com.sujal.dto.UserDTO;
import com.sujal.exception.UsersException;

@Repository("value=userRepository")
public class UserRepositoryImpl implements UserRepository {
	
	public Integer addUser(UserDTO  userDTO) throws UsersException {
		return userDTO.getUserId();
	}
}
 