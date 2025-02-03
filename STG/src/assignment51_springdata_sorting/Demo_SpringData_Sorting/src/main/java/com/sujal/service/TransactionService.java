package com.sujal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.sujal.dto.TransactionDTO;
import com.sujal.exception.SujalBankException;

public interface TransactionService {

	public List<TransactionDTO> getAllTransaction(Sort sort) throws SujalBankException;

	public List<TransactionDTO> getAllTransactionByTransactionDateAfter(LocalDate transactionDate, Pageable pageable) throws SujalBankException;

}
