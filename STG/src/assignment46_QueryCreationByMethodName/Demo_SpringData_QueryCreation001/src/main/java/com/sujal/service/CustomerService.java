package com.sujal.service;

import java.time.LocalDate;
import java.util.List;

import com.sujal.dto.CustomerDTO;
import com.sujal.exception.SujalBankException;

public interface CustomerService {

	public CustomerDTO findByEmailId(String emailId) throws SujalBankException;

	public CustomerDTO findByEmailIdAndName(String emailId, String name) throws SujalBankException;

	public List<CustomerDTO> findByEmailIdOrName(String emailId, String name) throws SujalBankException;

	public List<CustomerDTO> findByDateOfBirthBetween(LocalDate fromDate, LocalDate toDate) throws SujalBankException;

	public List<CustomerDTO> findByDateOfBirthLessThan(LocalDate dateOfBirth) throws SujalBankException;

	public List<CustomerDTO> findByDateOfBirthGreaterThan(LocalDate dateOfBirth) throws SujalBankException;

	public List<CustomerDTO> findByDateOfBirthAfter(LocalDate dateOfBirth) throws SujalBankException;

	public List<CustomerDTO> findByDateOfBirthBefore(LocalDate dateOfBirth) throws SujalBankException;

	public List<CustomerDTO> findByEmailIdNull() throws SujalBankException;

	public List<CustomerDTO> findByNameLike(String pattern) throws SujalBankException;

	public List<CustomerDTO> findByNameOrderByDateOfBirth(String name) throws SujalBankException;

	public List<CustomerDTO> findByNameOrderByDateOfBirthDesc(String name) throws SujalBankException;
}
