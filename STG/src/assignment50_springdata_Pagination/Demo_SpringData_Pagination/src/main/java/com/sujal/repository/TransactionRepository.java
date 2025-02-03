package com.sujal.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sujal.entity.Transaction;


public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Integer> {
	public List<Transaction> findByTransactionDateAfter(LocalDate transactionDate, Pageable pageable);
}