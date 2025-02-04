package com.sujal.repository;

import org.springframework.data.repository.CrudRepository;

import com.sujal.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}