package com.sujal.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sujal.dto.CustomerDTO;

@Repository(value = "customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {

	@Cacheable("custome")
	public CustomerDTO getCustomerDetails(Integer customerId) {
		
		CustomerDTO customer = null;
		List<CustomerDTO> customerList = new ArrayList<>();
		
		CustomerDTO customer1 = new CustomerDTO();
		customer1.setCustomerId(1);
		customer1.setName("Robin");
		customer1.setEmailId("robin@infosys.com");
		customerList.add(customer1);
		
		CustomerDTO customer2 = new CustomerDTO();
		customer2.setCustomerId(2);
		customer2.setName("James");
		customer2.setEmailId("james@infosys.com");
		customerList.add(customer2);
		
		CustomerDTO customer3 = new CustomerDTO();
		customer3.setCustomerId(3);
		customer3.setName("David");
		customer3.setEmailId("david@infosys.com");
		customerList.add(customer3);

		for (CustomerDTO cust : customerList) {
			if (cust.getCustomerId().equals(customerId)) {
				customer = cust;
			}
		}		
		return customer;

	}
}