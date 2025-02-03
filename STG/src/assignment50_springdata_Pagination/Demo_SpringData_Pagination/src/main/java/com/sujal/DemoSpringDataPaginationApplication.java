package com.sujal;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.sujal.dto.TransactionDTO;
import com.sujal.service.TransactionService;

@SpringBootApplication
public class DemoSpringDataPaginationApplication implements CommandLineRunner{

	private static final Log LOGGER = LogFactory.getLog(DemoSpringDataPaginationApplication.class);
	
	@Autowired
	TransactionService transactionService;
	@Autowired
	Environment environment;
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringDataPaginationApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		getAllTransactions();
		getAllTransactionsByTransactionDate();
	}
	
	public void getAllTransactions() {
		try {
			List<TransactionDTO> transactionList = transactionService.getAllTransaction(0, 5);
			transactionList.forEach(LOGGER::info);
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),
					"Some exception occurred. Please check log file for more details!!");
			LOGGER.info(message);
		}
	}
	public void getAllTransactionsByTransactionDate() {
		try {
			LocalDate transactionDate = LocalDate.of(1996, 1, 29);
			List<TransactionDTO> transactionList = transactionService.getAllTransactionByTransactionDateAfter(transactionDate, 0,2);
			transactionList.forEach(LOGGER::info);
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),
					"Some exception occurred. Please check log file for more details!!");
			LOGGER.info(message);
		}
	}

}
