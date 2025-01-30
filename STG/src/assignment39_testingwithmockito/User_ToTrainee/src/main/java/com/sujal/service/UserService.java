package com.sujal.service;

import com.sujal.dto.UserDTO;
import com.sujal.exception.UsersException;

public interface UserService {
	public Integer addUser(UserDTO  userDTO) throws UsersException;
}
