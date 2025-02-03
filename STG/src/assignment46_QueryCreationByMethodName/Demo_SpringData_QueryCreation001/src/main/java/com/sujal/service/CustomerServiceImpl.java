package com.sujal.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujal.dto.CustomerDTO;
import com.sujal.entity.Customer;
import com.sujal.exception.SujalBankException;
import com.sujal.repository.CustomerRepository;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public CustomerDTO findByEmailId(String emailId) throws SujalBankException {
		Optional<Customer> optional = customerRepository.findByEmailId(emailId);
		Customer customer = optional.orElseThrow(() -> new SujalBankException("Service.CUSTOMER_UNAVAILABLE"));
			
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setDateOfBirth(customer.getDateOfBirth());
		customerDTO.setEmailId(customer.getEmailId());
		customerDTO.setName(customer.getName());
		return customerDTO;
		
	}

	@Override
	public CustomerDTO findByEmailIdAndName(String emailId, String name) throws SujalBankException {
		Optional<Customer> optional = customerRepository.findByEmailIdAndName(emailId, name);
		Customer customer = optional.orElseThrow(() -> new SujalBankException("Service.CUSTOMER_UNAVAILABLE"));
		
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setDateOfBirth(customer.getDateOfBirth());
		customerDTO.setEmailId(customer.getEmailId());
		customerDTO.setName(customer.getName());
		return customerDTO;
	}

	@Override
	public List<CustomerDTO> findByEmailIdOrName(String emailId, String name) throws SujalBankException {
		List<Customer> customers = customerRepository.findByEmailIdOrName(emailId, name);
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		if (customers.isEmpty())
			throw new SujalBankException("Service.CUSTOMER_UNAVAILABLE");
		customers.forEach(customer -> {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setName(customer.getName());
			customerDTOs.add(customerDTO);
		});
		return customerDTOs;
	}

	@Override
	public List<CustomerDTO> findByDateOfBirthBetween(LocalDate fromDate, LocalDate toDate) throws SujalBankException {
		List<Customer> customers = customerRepository.findByDateOfBirthBetween(fromDate, toDate);
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		if (customers.isEmpty())
			throw new SujalBankException("Service.CUSTOMER_UNAVAILABLE");
		customers.forEach(customer -> {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setName(customer.getName());
			customerDTOs.add(customerDTO);
		});
		return customerDTOs;
	}

	@Override
	public List<CustomerDTO> findByDateOfBirthLessThan(LocalDate dateOfBirth) throws SujalBankException {
		List<Customer> customers = customerRepository.findByDateOfBirthLessThan(dateOfBirth);
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		if (customers.isEmpty())
			throw new SujalBankException("Service.CUSTOMER_UNAVAILABLE");
		customers.forEach(customer -> {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setName(customer.getName());
			customerDTOs.add(customerDTO);
		});
		return customerDTOs;
	}

	@Override
	public List<CustomerDTO> findByDateOfBirthGreaterThan(LocalDate dateOfBirth) throws SujalBankException {
		List<Customer> customers = customerRepository.findByDateOfBirthGreaterThan(dateOfBirth);
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		if (customers.isEmpty())
			throw new SujalBankException("Service.CUSTOMER_UNAVAILABLE");
		customers.forEach(customer -> {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setName(customer.getName());
			customerDTOs.add(customerDTO);
		});
		return customerDTOs;
	}

	@Override
	public List<CustomerDTO> findByDateOfBirthAfter(LocalDate dateOfBirth) throws SujalBankException {
		List<Customer> customers = customerRepository.findByDateOfBirthAfter(dateOfBirth);
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		if (customers.isEmpty())
			throw new SujalBankException("Service.CUSTOMER_UNAVAILABLE");
		customers.forEach(customer -> {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setName(customer.getName());
			customerDTOs.add(customerDTO);
		});
		return customerDTOs;
	}

	@Override
	public List<CustomerDTO> findByDateOfBirthBefore(LocalDate dateOfBirth) throws SujalBankException {
		List<Customer> customers = customerRepository.findByDateOfBirthBefore(dateOfBirth);
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		if (customers.isEmpty())
			throw new SujalBankException("Service.CUSTOMER_UNAVAILABLE");
		customers.forEach(customer -> {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setName(customer.getName());
			customerDTOs.add(customerDTO);
		});
		return customerDTOs;
	}

	@Override
	public List<CustomerDTO> findByEmailIdNull() throws SujalBankException {
		List<Customer> customers = customerRepository.findByEmailIdNull();
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		if (customers.isEmpty())
			throw new SujalBankException("Service.CUSTOMER_UNAVAILABLE");
		customers.forEach(customer -> {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setName(customer.getName());
			customerDTOs.add(customerDTO);
		});
		return customerDTOs;
	}

	@Override
	public List<CustomerDTO> findByNameLike(String pattern) throws SujalBankException {
		List<Customer> customers = customerRepository.findByNameLike(pattern);
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		if (customers.isEmpty())
			throw new SujalBankException("Service.CUSTOMER_UNAVAILABLE");
		customers.forEach(customer -> {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setName(customer.getName());
			customerDTOs.add(customerDTO);
		});
		return customerDTOs;
	}

	@Override
	public List<CustomerDTO> findByNameOrderByDateOfBirth(String name) throws SujalBankException {
		List<Customer> customers = customerRepository.findByNameOrderByDateOfBirth(name);
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		if (customers.isEmpty())
			throw new SujalBankException("Service.CUSTOMER_UNAVAILABLE");
		customers.forEach(customer -> {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setName(customer.getName());
			customerDTOs.add(customerDTO);
		});
		return customerDTOs;
	}

	@Override
	public List<CustomerDTO> findByNameOrderByDateOfBirthDesc(String name) throws SujalBankException {
		List<Customer> customers = customerRepository.findByNameOrderByDateOfBirthDesc(name);
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		if (customers.isEmpty())
			throw new SujalBankException("Service.CUSTOMER_UNAVAILABLE");
		customers.forEach(customer -> {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setName(customer.getName());
			customerDTOs.add(customerDTO);
		});
		return customerDTOs;
	}

}
