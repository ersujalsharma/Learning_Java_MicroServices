package com.sujal.validator;

import com.sujal.dto.TransactionDTO;
import com.sujal.exception.IRetailException;

public class Validator {
	
	public static void validate(TransactionDTO transactionDTO) throws IRetailException {
		if (!validateAmount(transactionDTO.getAmount()))
			throw new IRetailException("Validator.INVALID_AMOUNT");
		if (!validateCustomerId(transactionDTO.getCustomerId()))
			throw new IRetailException("Validator.INVALID_CUSTOMER_ID");

	}

	public static Boolean validateAmount(Double amount) {
		if (amount > 0d)
			return true;
		else
			return false;
	}

	public static Boolean validateCustomerId(String customerId) {
		if(customerId.startsWith("C") && customerId.length() == 5)
			return true;
		else
			return false;
	}

}