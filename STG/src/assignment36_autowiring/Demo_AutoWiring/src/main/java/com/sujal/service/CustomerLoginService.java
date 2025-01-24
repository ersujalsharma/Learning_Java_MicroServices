package com.sujal.service;

import com.sujal.dto.CustomerLoginDTO;
import com.sujal.exception.BankException;

public interface CustomerLoginService {
	public String authenticateCustomer(CustomerLoginDTO customerLogin) throws BankException;
}
