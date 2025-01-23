package com.sujal;

import java.time.LocalDateTime;

//Create a Transaction record with the fields transactionId(Integer),
//accountNumber(String), amount(Double), timestamp(LocalDateTime)
public record Transaction(Integer transactionId, String accountNumber, Double amount, LocalDateTime timestamp) {

        private static final Double MINIMUM_TRANS_AMOUNT = 200.0;
        private static Integer counter = 100;
        public Transaction(Double amount, LocalDateTime timestamp) {
                this(counter,"ACCT"+counter,amount, timestamp);
                counter++;
        }
        public static boolean isSignificant(Transaction transaction) {
            return transaction.amount() >= MINIMUM_TRANS_AMOUNT;
        }
}
//Initialize the static final variable MINIMUM_TRANS_AMOUNT(Double) with the value 200.0 
//and a static variable counter with a value 100

//Create a constructor which takes amount and time stamp as input parameters
	//Initialize transactionId beginning with CHA followed by pre-incremented counter value
	//and the accountNumber as ACCT100

//Create a static method isSignificant() which accepts the Transaction 
//object to check whether the transaction amount is greater than or equal to 
//MINIMUM_TRANS_AMOUNT
