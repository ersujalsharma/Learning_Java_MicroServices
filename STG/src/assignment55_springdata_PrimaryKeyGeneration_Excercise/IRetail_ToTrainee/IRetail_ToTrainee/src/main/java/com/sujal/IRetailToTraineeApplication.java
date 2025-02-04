package com.sujal;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.sujal.dto.TransactionDTO;
import com.sujal.service.TransactionService;

@SpringBootApplication
public class IRetailToTraineeApplication implements CommandLineRunner {
	
	public static final Logger LOGGER = LogManager.getLogger(IRetailToTraineeApplication.class);

	@Autowired
	TransactionService transactionService;

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(IRetailToTraineeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		makeTransaction();
		getTransactionDetails();	

	}

	public void makeTransaction() {
		try {
			TransactionDTO transactionDTO = new TransactionDTO();
			transactionDTO.setCustomerId("C5001");
			transactionDTO.setTransactionDateTime(LocalDate.now());
			transactionDTO.setAmount(150.40d);

			Integer transactionId = transactionService.makeTransaction(transactionDTO);

			LOGGER.info(environment.getProperty("UserInterface.TRANSACTION_SUCCESSFUL") + transactionId);

		} catch (Exception e) {
			LOGGER.info(environment.getProperty(e.getMessage(), "Some exception occured. Please check log file."));

		}
	}

	public void getTransactionDetails() {
		try {

			TransactionDTO transactionDTO = transactionService.getTransactionDetails(1004);

			LOGGER.info(transactionDTO);

		} catch (Exception e) {
			LOGGER.info(environment.getProperty(e.getMessage(), "Some exception occured. Please check log file."));

		}

	}

}
