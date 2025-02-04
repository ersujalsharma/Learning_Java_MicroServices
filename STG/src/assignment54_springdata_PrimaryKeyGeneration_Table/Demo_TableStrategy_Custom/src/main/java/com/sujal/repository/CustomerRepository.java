package com.sujal.repository;

import org.springframework.data.repository.CrudRepository;

import com.sujal.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}