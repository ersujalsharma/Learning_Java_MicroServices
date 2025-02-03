package com.sujal.repository;

import com.sujal.dto.CustomerDTO;

public interface CustomerRepository {
	public CustomerDTO getCustomerDetails(Integer customerId);
}
