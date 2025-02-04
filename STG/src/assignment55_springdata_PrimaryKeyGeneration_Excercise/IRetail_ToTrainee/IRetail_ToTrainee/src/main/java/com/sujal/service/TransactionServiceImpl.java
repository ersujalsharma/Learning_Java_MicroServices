package com.sujal.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujal.dto.TransactionDTO;
import com.sujal.entity.Transaction;
import com.sujal.exception.IRetailException;
import com.sujal.repository.TransactionRepository;
import com.sujal.validator.Validator;

import jakarta.transaction.Transactional;

@Service(value="transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	/**
	 This method first calls validate method of Validator passing TransactionDTO object received in parameter,
	 then calls save method of transactionRepository by passing Transaction entity object.
	 @param Transaction object
	 @return transactionId returned after calling save method of transactionRepository
	 */
	public Integer makeTransaction(TransactionDTO transactionDTO) throws IRetailException {
		Validator.validate(transactionDTO);
		Transaction transaction = new Transaction();
		transaction.setAmount(transactionDTO.getAmount());
		transaction.setCustomerId(transactionDTO.getCustomerId());
		transaction.setTransactionDateTime(transactionDTO.getTransactionDateTime());
		transaction.setTransactionId(transactionDTO.getTransactionId());
		return transactionRepository.save(transaction).getTransactionId();
	}

	/**
	 This method  calls  findById method of transactionRepository passing transactionId  received in parameter
	 @param Integer transactionId
	 @return TransactionDTO object populated by Transaction Entity object returned from findById method of transactionRepository
	 @throws Service.INVALID_TRANSACTION_ID exception if object returned from findById method of transactionRepository is null
	 */
	public TransactionDTO getTransactionDetails(Integer transactionId) throws IRetailException {
		Optional<Transaction> op = transactionRepository.findById(transactionId);
		if(!op.isPresent()) {
			throw new IRetailException("Service.INVALID_TRANSACTION_ID");
		}
		Transaction transaction = op.get();
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setAmount(transaction.getAmount());
		transactionDTO.setCustomerId(transaction.getCustomerId());
		transactionDTO.setTransactionDateTime(transaction.getTransactionDateTime());
		transactionDTO.setTransactionId(transaction.getTransactionId());
		return transactionDTO;
	}



}
