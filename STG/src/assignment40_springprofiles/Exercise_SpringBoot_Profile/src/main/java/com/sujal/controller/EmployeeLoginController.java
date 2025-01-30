package com.sujal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sujal.dto.EmployeeLogin;
import com.sujal.exception.EmployeeAuthenticateException;
import com.sujal.service.EmployeeLoginService;

@Controller(value="employeeLoginController")
public class EmployeeLoginController {

	@Autowired
	private EmployeeLoginService employeeLoginService;

	public String authenticateEmployee(EmployeeLogin employeeLogin) throws EmployeeAuthenticateException {
		return employeeLoginService.authenticateCustomer(employeeLogin);
	}
}
