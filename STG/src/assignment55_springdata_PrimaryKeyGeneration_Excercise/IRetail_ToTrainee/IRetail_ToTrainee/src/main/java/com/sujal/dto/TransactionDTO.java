package com.sujal.dto;

import java.time.LocalDate;


public class TransactionDTO {

	private Integer transactionId;
	private String customerId;
	private LocalDate transactionDateTime;
	private Double amount;
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public LocalDate getTransactionDateTime() {
		return transactionDateTime;
	}
	public void setTransactionDateTime(LocalDate transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "TransactionDTO [transactionId=" + transactionId + ", customerId=" + customerId
				+ ", transactionDateTime=" + transactionDateTime + ", amount=" + amount + "]";
	}

	
	
}
