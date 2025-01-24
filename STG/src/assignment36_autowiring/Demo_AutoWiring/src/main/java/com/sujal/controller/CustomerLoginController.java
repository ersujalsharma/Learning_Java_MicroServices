package com.sujal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sujal.dto.CustomerLoginDTO;
import com.sujal.exception.BankException;
import com.sujal.service.CustomerLoginService;

@Controller(value="customerLoginController")
public class CustomerLoginController {

	@Autowired
	private CustomerLoginService customerLoginService;

	public String authenticateCustomer(CustomerLoginDTO customerLogin) throws BankException {
		return customerLoginService.authenticateCustomer(customerLogin);
		 
	}
}
