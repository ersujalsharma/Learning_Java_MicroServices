package com.sujal.service;

import com.sujal.exception.sujalBankException;

public interface CustomerService {
	String findNameByEmailId(String emailId);
	void updateCustomerEmailId(String newEmailId, Integer customerId) throws sujalBankException;
	void deleteCustomerByEmailId(String emailId) throws sujalBankException;
}
