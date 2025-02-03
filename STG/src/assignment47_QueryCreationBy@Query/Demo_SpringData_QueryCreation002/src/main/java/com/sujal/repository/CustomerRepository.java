package com.sujal.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sujal.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	@Query("SELECT c.name FROM Customer c WHERE c.emailId = :emailId")
	String findNameByEmailId(@Param("emailId") String emailId);

	@Query("UPDATE Customer c SET c.emailId = :emailId WHERE c.customerId = :customerId")
	@Modifying
	@Transactional
	Integer updateCustomerEmailId(@Param("emailId") String updateCustomerByEmailId, @Param("customerId") Integer customerId);

	@Query("DELETE FROM Customer c WHERE c.emailId = :emailId")
	@Modifying
	@Transactional
	Integer deleteCustomerByEmailId(@Param("emailId") String emailId);
}