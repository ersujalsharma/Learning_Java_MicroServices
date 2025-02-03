package com.sujal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujal.entity.Customer;
import com.sujal.exception.sujalBankException;
import com.sujal.repository.CustomerRepository;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String findNameByEmailId(String emailId) {
		return customerRepository.findNameByEmailId(emailId);
	}

	@Override
	public void updateCustomerEmailId(String newEmailId, Integer customerId) throws sujalBankException {
		Optional<Customer> optional = customerRepository.findById(customerId);

		optional.orElseThrow(() -> new sujalBankException("Service.CUSTOMER_UNAVAILABLE"));
		
		customerRepository.updateCustomerEmailId(newEmailId, customerId);
		

	}

	@Override
	public void deleteCustomerByEmailId(String emailId) throws sujalBankException {
		// Optional<CustomerEntity> customer = customerRespository.fi

		Integer count = customerRepository.deleteCustomerByEmailId(emailId);
		if (count == 0)
			throw new sujalBankException("Service.CUSTOMER_UNAVAILABLE");

	}

}
