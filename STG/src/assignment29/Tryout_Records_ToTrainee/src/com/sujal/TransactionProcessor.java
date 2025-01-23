package com.sujal;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionProcessor {

	public static void main(String[] args) {
		Transaction transaction1 = new Transaction(1, "ACCT123", 1000.0, LocalDateTime.now());
		Transaction transaction2 = new Transaction(2, "ACCT456", 150.0, LocalDateTime.now());
		Transaction transaction3 = new Transaction(2550.0, LocalDateTime.now());

		// Create an ArrayList of transactions and add the above transactions to the
		List<Transaction> transactions = List.of(transaction1, transaction2, transaction3);
		for (int i = 0; i < transactions.size(); i++) {
			System.out.println(transactions.get(i).toString());
			System.out.println("Transaction " + (i + 1) + " is significant: "
					+ transactions.get(i).isSignificant(transactions.get(i)));
		}

		// Attempt to modify the record fields (will cause compilation error)
		// Compilation error: cannot assign a value to final variable amount
		// transaction1.amount = 200.0; 
		
		// Iterate over the above list to check whether the transaction is significant
		// or not
		
		

	}
}