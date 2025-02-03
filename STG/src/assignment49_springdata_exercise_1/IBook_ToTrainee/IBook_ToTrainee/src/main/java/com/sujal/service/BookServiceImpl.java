package com.sujal.service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujal.dto.BookDTO;
import com.sujal.entity.Book;
import com.sujal.exception.sujalBookException;
import com.sujal.repository.BookRepository;
import com.sujal.validator.Validator;

import jakarta.transaction.Transactional;

@Service(value="bookService")
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public BookDTO getBookDetails(Integer bookId) throws sujalBookException {
		Optional<Book> op = bookRepository.findById(bookId);
		if(!op.isPresent()) throw new sujalBookException("Service.BOOK_DETAILS_NOT_FOUND");
		Book book = op.get();
		BookDTO bookDTO = new BookDTO(bookId, book.getTitle(), book.getAuthorName(), book.getPublishedYear(), book.getPublisher(), book.getIsbn(), book.getPrice());
		return bookDTO;
	}

	@Override
	public void addBook(BookDTO bookDTO) throws sujalBookException {
		Validator.validate(bookDTO);
		Optional<Book> op = bookRepository.findById(bookDTO.getBookId());
		if(!op.isPresent()) {
			throw new sujalBookException("Service.BOOK_ALREADY_PRESENT");
		}
		bookRepository.save(op.get());
	}

	@Override
	public List<BookDTO> getBookByAuthorName(String authorName) throws sujalBookException {
		List<Book> list = bookRepository.findAllByAuthorName(authorName);
		List<BookDTO> bookList = list.stream().map(t->new BookDTO(t.getBookId(), t.getTitle(), t.getAuthorName(), t.getPublishedYear(), t.getPublisher(), t.getIsbn(), t.getPrice())).toList();
		if(bookList==null || bookList.isEmpty()) throw new sujalBookException("Service.BOOK_NOT_FOUND");
		return bookList;
	}

	@Override
	public List<BookDTO> getBookGreaterThanEqualToPrice(Integer price) throws sujalBookException {
		List<Book> list = bookRepository.findAllByPriceGreaterThanEqual(price);
		List<BookDTO> bookList = list.stream().map(t->new BookDTO(t.getBookId(), t.getTitle(), t.getAuthorName(), t.getPublishedYear(), t.getPublisher(), t.getIsbn(), t.getPrice())).toList();
		if(bookList==null || bookList.isEmpty()) throw new sujalBookException("Service.BOOK_NOT_FOUND");
		return bookList;
	}

	@Override
	public List<BookDTO> getBookLessThanPrice(Integer price) throws sujalBookException {
		List<Book> list = bookRepository.findAllByPriceLessThanEqual(price);
		List<BookDTO> bookList = list.stream().map(t->new BookDTO(t.getBookId(), t.getTitle(), t.getAuthorName(), t.getPublishedYear(), t.getPublisher(), t.getIsbn(), t.getPrice())).toList();
		if(bookList==null || bookList.isEmpty()) throw new sujalBookException("Service.BOOK_NOT_FOUND");
		return bookList;
	}

	@Override
	public List<BookDTO> bookPublishedBetweenYear(LocalDate startYear, LocalDate endYear) throws sujalBookException {
		List<Book> list = bookRepository.findAllByPublishedYearBetween(startYear, endYear);
		List<BookDTO> bookList = list.stream().map(t->new BookDTO(t.getBookId(), t.getTitle(), t.getAuthorName(), t.getPublishedYear(), t.getPublisher(), t.getIsbn(), t.getPrice())).toList();
		if(bookList==null || bookList.isEmpty()) throw new sujalBookException("Service.BOOK_NOT_FOUND");
		return bookList;
	}

	@Override
	public List<BookDTO> bookPublishedAfterYear(LocalDate year) throws sujalBookException {
		List<Book> list = bookRepository.findAllByPublishedYearAfter(year);
		List<BookDTO> bookList = list.stream().map(t->new BookDTO(t.getBookId(), t.getTitle(), t.getAuthorName(), t.getPublishedYear(), t.getPublisher(), t.getIsbn(), t.getPrice())).toList();
		if(bookList==null || bookList.isEmpty()) throw new sujalBookException("Service.BOOK_NOT_FOUND");
		return bookList;
	}

	@Override
	public List<BookDTO> getBookByAuthorNameAndPublisher(String authorName, String publisher) throws sujalBookException {
		List<Book> list = bookRepository.findAllByAuthorNameAndPublisher(authorName,publisher);
		List<BookDTO> bookList = list.stream().map(t->new BookDTO(t.getBookId(), t.getTitle(), t.getAuthorName(), t.getPublishedYear(), t.getPublisher(), t.getIsbn(), t.getPrice())).toList();
		if(bookList==null || bookList.isEmpty()) throw new sujalBookException("Service.BOOK_NOT_FOUND");
		return bookList;
	}

	@Override
	public void updateBookPrice(Integer bookId, Integer price) throws sujalBookException {
		Optional<Book> op = bookRepository.findById(bookId);
		if(!op.isPresent()) throw new sujalBookException("Service.BOOK_NOT_FOUND");
		Book book = op.get();
		book.setPrice(price);
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(Integer bookId) throws sujalBookException {
		Optional<Book> op = bookRepository.findById(bookId);
		if(!op.isPresent()) throw new sujalBookException("Service.BOOK_NOT_FOUND");
		Book book = op.get();
		bookRepository.delete(book);
	}


	
}
