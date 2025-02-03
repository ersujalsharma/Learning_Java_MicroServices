package com.sujal;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sujal.entity.Customer;
import com.sujal.repository.CustomerRespository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class DemoSpringDataApplication implements CommandLineRunner {

	private static final Log LOGGER = LogFactory.getLog(DemoSpringDataApplication.class);
	@Autowired
	CustomerRespository customerRepository;
	
	@PersistenceContext
	EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringDataApplication.class, args);

	}
	@Transactional
	public void run(String... args) throws Exception {

		Customer customer1 = new Customer(2, "monica@sujal.com", "Monica", LocalDate.of(1987, 4, 2));
		Customer customer2 = new Customer(3, "allen@sujal.com", "Allen", LocalDate.of(1980, 4, 2));

		// save customers
		customerRepository.save(customer1);
		customerRepository.save(customer1);
		customerRepository.save(customer2);

		// fetch customer by id
		LOGGER.info("Customer fetched by findById(1)");
		LOGGER.info("-------------------------------");
		Customer customer3 = customerRepository.findById(1).get();
		LOGGER.info(customer3);

		// fetching all customers
		LOGGER.info("Customers fetched by findAll()");
		LOGGER.info("-------------------------------");
		Iterable<Customer> customers = customerRepository.findAll();
		customers.forEach(LOGGER::info);
		
		//  JPQL
		
		// Select -
		// Single 
		// What if multiple rows query is executed with getSingleResult()?
		// Exception is thrown - NonUniqueResultException
		/*
		 * Query query = entityManager.createQuery("SELECT c FROM Customer c"); //
		 * Customer c = (Customer) query.getSingleResult(); // LOGGER.info(c);
		 */		
		
		/*
		 * Query query2 =
		 * entityManager.createQuery("SELECT c FROM Customer c where c.customerId = 1");
		 * Customer c2 = (Customer) query2.getSingleResult(); LOGGER.info(c2);
		 */
		

//		Query query3 = entityManager.createQuery("SELECT c.name, c.dateOfBirth FROM Customer c");
//		List<Object[]> customers3 = query3.getResultList();
//		LOGGER.info(customers3);
//		for(Object c[] : customers3) {
//			System.out.println(c);
//		}
		// execute unique row result query with getResultList() 
//		Query query3 = entityManager.createQuery("SELECT c FROM Customer c where c.customerId = 1");
//		List<Customer> c3 = query3.getResultList();
//		LOGGER.info(c3);
		
		// update query with getResult
//		Query query4 = entityManager.createQuery("Update Customer c set c.emailId=sujalsharma350@gmail.com where c.customerId=1");
//		List<Customer> c4 = query4.getSingleResult();
//		LOGGER.info(c4);
	
//		Query query4 = entityManager.createQuery("Update Customer c set c.emailId='sujalsharma350@gmail.com' where c.customerId=1");
//		List<Customer> c4 = query4.getResultList();
//		
		// update with executeUpdate()
		try {
			Query query5 = entityManager.createQuery("Update Customer c set c.emailId='sujalsharma350@gmail.com' where c.customerId=1");
			int val = query5.executeUpdate();
			System.out.println(val);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
