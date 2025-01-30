package com.sujal.service;

import com.sujal.dto.EmployeeLogin;
import com.sujal.exception.EmployeeAuthenticateException;

public interface EmployeeLoginService {
	public String authenticateCustomer(EmployeeLogin employeeLogin)
			throws EmployeeAuthenticateException;
}
