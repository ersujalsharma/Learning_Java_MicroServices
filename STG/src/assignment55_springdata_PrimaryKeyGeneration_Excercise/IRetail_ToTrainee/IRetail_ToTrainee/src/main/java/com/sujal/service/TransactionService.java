package com.sujal.service;

import com.sujal.dto.TransactionDTO;
import com.sujal.exception.IRetailException;

public interface TransactionService {
	public Integer makeTransaction(TransactionDTO transactionDTO) throws IRetailException;

	public TransactionDTO getTransactionDetails(Integer transactionId) throws IRetailException;
	
}
