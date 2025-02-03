package com.sujal;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.sujal.dto.BookDTO;
import com.sujal.service.BookService;

@SpringBootApplication
public class IBookToTraineeApplication implements CommandLineRunner {

	private static final Logger LOGGER = LogManager.getLogger(IBookToTraineeApplication.class);

	private static final String GENERAL_ERROR = "Some exception occured.Please check log file.";

	@Autowired
	Environment environment;
	@Autowired
	BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(IBookToTraineeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		getBookDetails();
		addBook();
		getBookByAuthorName();
		getBookGreaterThanEqualToPrice();
		getBookLessThanPrice();
		bookPublishedBetweenYear();
		bookPublishedAfterYear();
		getBookByAuthorNameAndPublisher();
		updateBookPrice();
		deleteBook();
	}

	public void getBookDetails() {
		try {

			// Input= BookId
			BookDTO bookdto = bookService.getBookDetails(1001);

			LOGGER.info(bookdto);

		} catch (Exception e) {
			LOGGER.info("\n" + environment.getProperty(e.getMessage(), GENERAL_ERROR));

		}
	}

	public void addBook() {
		try {
			BookDTO bookdto = new BookDTO();
			bookdto.setBookId(1010);
			bookdto.setTitle("The Da Vinci Code");
			bookdto.setAuthorName("Dan Brown");
			bookdto.setPublishedYear(LocalDate.of(2003, 04, 18));
			bookdto.setPublisher("Doubleday");
			bookdto.setIsbn(1456987609875l);
			bookdto.setPrice(980);

			bookService.addBook(bookdto);
			LOGGER.info("\n" + environment.getProperty("UserInterface.INSERT_SUCCESS"));

		} catch (Exception e) {

			LOGGER.info("\n" + environment.getProperty(e.getMessage(), GENERAL_ERROR));

		}
	}

	public void getBookByAuthorName() {
		try {
			String authorName = "Nicholas Sparks";
			List<BookDTO> bookDTOs = bookService.getBookByAuthorName(authorName);
			LOGGER.info("\n");
			bookDTOs.forEach(bookDTO -> LOGGER.info(bookDTO));

		} catch (Exception e) {
			LOGGER.info("\n" + environment.getProperty(e.getMessage(), GENERAL_ERROR));

		}
	}

	public void getBookGreaterThanEqualToPrice() {
		try {
			Integer price = 700;
			List<BookDTO> bookDTOs = bookService.getBookGreaterThanEqualToPrice(price);
			LOGGER.info("\n");
			bookDTOs.forEach(bookDTO -> LOGGER.info(bookDTO));

		} catch (Exception e) {
			LOGGER.info("\n" + environment.getProperty(e.getMessage(), GENERAL_ERROR));

		}
	}

	public void getBookLessThanPrice() {
		try {
			Integer price = 600;
			List<BookDTO> bookDTOs = bookService.getBookLessThanPrice(price);
			LOGGER.info("\n");
			bookDTOs.forEach(bookDTO -> LOGGER.info(bookDTO));

		} catch (Exception e) {
			LOGGER.info("\n" + environment.getProperty(e.getMessage(), GENERAL_ERROR));

		}
	}

	public void bookPublishedBetweenYear() {
		try {
			LocalDate startYear = LocalDate.of(1990, 12, 22);
			LocalDate endYear = LocalDate.of(2000, 12, 22);
			List<BookDTO> bookDTOs = bookService.bookPublishedBetweenYear(startYear, endYear);
			LOGGER.info("\n");
			bookDTOs.forEach(bookDTO -> LOGGER.info(bookDTO));
		} catch (Exception e) {
			LOGGER.info("\n" + environment.getProperty(e.getMessage(), GENERAL_ERROR));
		}
	}

	public void bookPublishedAfterYear() {
		try {
			LocalDate year = LocalDate.of(2000, 12, 22);

			List<BookDTO> bookDTOs = bookService.bookPublishedAfterYear(year);
			LOGGER.info("\n");
			bookDTOs.forEach(bookDTO -> LOGGER.info(bookDTO));

		} catch (Exception e) {
			LOGGER.info("\n" + environment.getProperty(e.getMessage(), GENERAL_ERROR));

		}
	}

	public void getBookByAuthorNameAndPublisher() {
		try {
			String authorName = "Amish Tripathi";
			String publisher = "Westland Press";
			List<BookDTO> bookDTOs = bookService.getBookByAuthorNameAndPublisher(authorName, publisher);
			LOGGER.info("\n");
			bookDTOs.forEach(bookDTO -> LOGGER.info(bookDTO));
		} catch (Exception e) {
			LOGGER.info("\n" + environment.getProperty(e.getMessage(), GENERAL_ERROR));
		}
	}

	public void updateBookPrice() {
		try {

			Integer bookId = 1005;
			Integer price = 850;

			bookService.updateBookPrice(bookId, price);
			LOGGER.info("\n" + environment.getProperty("UserInterface.UPDATE_SUCCESS"));

		} catch (Exception e) {
			LOGGER.info("\n" + environment.getProperty(e.getMessage(), GENERAL_ERROR));

		}
	}

	public void deleteBook() {
		try {

			bookService.deleteBook(1005);
			LOGGER.info("\n" + environment.getProperty("UserInterface.DELETE_SUCCESS"));
		} catch (Exception e) {
			LOGGER.info("\n" + environment.getProperty(e.getMessage(), GENERAL_ERROR));

		}
	}

}
