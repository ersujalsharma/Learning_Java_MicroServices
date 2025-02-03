package com.sujal.service;
import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sujal.dto.TransactionDTO;
import com.sujal.entity.Transaction;
import com.sujal.exception.SujalBankException;
import com.sujal.repository.TransactionRepository;

@Service(value = "transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	@Override
	public List<TransactionDTO> getAllTransaction(Integer pageNo, Integer pageSize) throws SujalBankException {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Transaction> page = transactionRepository.findAll(pageable);
		if (page.isEmpty()) {
			throw new SujalBankException("Service.NO_CUSTOMERS_IN_THIS_PAGE");
		}
		List<Transaction> entityList = page.getContent();
		List<TransactionDTO> transactionDTOs;
		transactionDTOs = entityList.stream()
				.map(p -> new TransactionDTO(p.getTransactionId(), p.getTransactionDate(), p.getTransactionAmount()))
				.collect(Collectors.toList());
		return transactionDTOs;
	}
	@Override
	public List<TransactionDTO> getAllTransactionByTransactionDateAfter(LocalDate transactionDate, Integer pageNo,
			Integer pageSize) throws SujalBankException {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		List<Transaction> transactions = transactionRepository.findByTransactionDateAfter(transactionDate, pageable);
		if (transactions.isEmpty()) {
			throw new SujalBankException("Service.NO_CUSTOMERS_IN_THIS_PAGE");
		}
		List<TransactionDTO> transactionDTOs;
		
		transactionDTOs = transactions.stream()
				.map(transaction -> new TransactionDTO(transaction.getTransactionId(), transaction.getTransactionDate(), transaction.getTransactionAmount()))
				.collect(Collectors.toList());
		return transactionDTOs;
	}
}