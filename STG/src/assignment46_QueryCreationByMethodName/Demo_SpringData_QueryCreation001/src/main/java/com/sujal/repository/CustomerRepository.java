package com.sujal.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.data.repository.CrudRepository;

import com.sujal.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	Optional<Customer> findByEmailId(String emailId);

	Optional<Customer> findByEmailIdAndName(String emailId, String name);

	List<Customer> findByEmailIdOrName(String emailId, String name);

	List<Customer> findByDateOfBirthBetween(LocalDate fromDate, LocalDate toDate);

	List<Customer> findByDateOfBirthLessThan(LocalDate dateOfBirth);

	List<Customer> findByDateOfBirthGreaterThan(LocalDate dateOfBirth);

	List<Customer> findByDateOfBirthAfter(LocalDate dateOfBirth);

	List<Customer> findByDateOfBirthBefore(LocalDate dateOfBirth);

	List<Customer> findByEmailIdNull();

	List<Customer> findByNameLike(String pattern);

	List<Customer> findByNameOrderByDateOfBirth(String name);

	List<Customer> findByNameOrderByDateOfBirthDesc(String name);

}
