package com.sujal.service;

import java.time.LocalDate;
import java.util.List;

import com.sujal.dto.TransactionDTO;
import com.sujal.exception.SujalBankException;

public interface TransactionService {
	public List<TransactionDTO> getAllTransaction(Integer pageNo, Integer pageSize) throws SujalBankException;

	public List<TransactionDTO> getAllTransactionByTransactionDateAfter(LocalDate transactionDate, Integer pageNo,
			Integer pageSize) throws SujalBankException;
}