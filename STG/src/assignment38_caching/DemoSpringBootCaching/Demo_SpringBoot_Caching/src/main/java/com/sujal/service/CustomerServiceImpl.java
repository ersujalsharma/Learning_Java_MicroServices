package com.sujal.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sujal.dto.CustomerDTO;
import com.sujal.exception.SujalBankException;
import com.sujal.repository.CustomerRepository;

@Service(value="customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public CustomerDTO getCustomerDetails(Integer customerId) throws SujalBankException {
		return customerRepository.getCustomerDetails(customerId);		
	}
}
