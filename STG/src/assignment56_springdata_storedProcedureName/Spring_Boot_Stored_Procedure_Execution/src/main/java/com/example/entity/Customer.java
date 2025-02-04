package com.example.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQuery(name = "Customer.getTotalCustomersByEmailId"
, procedureName = "GET_TOTAL_CUSTOMER_BY_EMAIL", parameters = {
@StoredProcedureParameter(mode = ParameterMode.IN, name = "email_id", type = String.class),
@StoredProcedureParameter(mode = ParameterMode.OUT, name = "count_out", type = Integer.class)}) 
public class Customer {
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", emailId=" + emailId
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @Column(name = "name")
    private String customerName;
    private String emailId;
    private LocalDate dateOfBirth;
    public Integer getCustomerId() {
                   return customerId;
    }
    public void setCustomerId(Integer customerId) {
                   this.customerId = customerId;
    }
    public String getCustomerName() {
                   return customerName;
    }
    public void setCustomerName(String customerName) {
                   this.customerName = customerName;
    }
    public String getEmailId() {
                   return emailId;
    }
    public void setEmailId(String emailId) {
                   this.emailId = emailId;
    }
    public LocalDate getDateOfBirth() {
                   return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
                   this.dateOfBirth = dateOfBirth;
    }
}
