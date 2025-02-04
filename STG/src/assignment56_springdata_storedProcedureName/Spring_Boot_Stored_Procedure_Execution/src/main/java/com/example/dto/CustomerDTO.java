package com.example.dto;

import java.time.LocalDate;

import com.example.entity.Customer;

public class CustomerDTO {
	public CustomerDTO(Integer customerId, String emailId, String name, LocalDate dateOfBirth) {
		super();
		this.customerId = customerId;
		this.emailId = emailId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	private Integer customerId;
	private String emailId;
	private String name;
	private LocalDate dateOfBirth;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
	public static CustomerDTO prepareDTO(Customer c) {
        return new CustomerDTO(c.getCustomerId(), c.getEmailId(), c.getCustomerName(), c.getDateOfBirth());
	}
}
