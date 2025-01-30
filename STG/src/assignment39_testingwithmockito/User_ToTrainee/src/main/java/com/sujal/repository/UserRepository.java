package com.sujal.repository;

import com.sujal.dto.UserDTO;
import com.sujal.exception.UsersException;

public interface UserRepository {

	public Integer addUser(UserDTO  userDTO) throws UsersException;

}
