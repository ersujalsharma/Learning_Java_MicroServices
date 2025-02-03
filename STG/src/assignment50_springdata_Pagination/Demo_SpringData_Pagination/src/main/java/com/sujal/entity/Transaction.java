package com.sujal.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction {
	@Id
	private Integer transactionId;
	private LocalDate transactionDate;
	private Float transactionAmount;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getTransactionId() == null) ? 0 : this.getTransactionId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (this.getTransactionId() == null) {
			if (other.getTransactionId() != null)
				return false;
		} 
		else if (!this.getTransactionId().equals(other.getTransactionId()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", transactionAmount=" + transactionAmount + "]";
	}

}