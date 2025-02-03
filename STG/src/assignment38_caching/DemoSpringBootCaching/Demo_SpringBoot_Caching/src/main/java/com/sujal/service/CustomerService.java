package com.sujal.service;

import com.sujal.dto.CustomerDTO;
import com.sujal.exception.SujalBankException;

public interface CustomerService {
	public CustomerDTO getCustomerDetails(Integer customerId) throws SujalBankException;
}
