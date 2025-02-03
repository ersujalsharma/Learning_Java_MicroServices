package com.sujal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujal.repository.CustomerRepository;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRespository;

	@Override
	public String findNameByEmailId(String emailId) {
		return customerRespository.findNameByEmailId(emailId);
	}

}
