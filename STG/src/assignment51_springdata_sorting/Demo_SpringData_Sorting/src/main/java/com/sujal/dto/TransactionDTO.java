package com.sujal.dto;

import java.time.LocalDate;

public class TransactionDTO {
	private Integer transactionId;
	private LocalDate transactionDate;
	private Float transactionAmount;

	public TransactionDTO(Integer transactionId, LocalDate transactionDate, Float transactionAmount) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", transactionAmount=" + transactionAmount + "]";
	}
}