package com.sujal.service;

import java.time.LocalDate;
import java.util.List;

import com.sujal.dto.BookDTO;
import com.sujal.exception.sujalBookException;

public interface BookService {
	
	public BookDTO getBookDetails(Integer bookId) throws sujalBookException;
	public void addBook(BookDTO bookDTO) throws sujalBookException;
	public List<BookDTO> getBookByAuthorName(String authorName) throws sujalBookException;
	public List<BookDTO> getBookGreaterThanEqualToPrice(Integer price) throws sujalBookException;
	public List<BookDTO> getBookLessThanPrice(Integer price) throws sujalBookException;
	public List<BookDTO> bookPublishedBetweenYear(LocalDate startYear, LocalDate endYear) throws sujalBookException;
	public List<BookDTO> bookPublishedAfterYear(LocalDate year) throws sujalBookException;
	public List<BookDTO> getBookByAuthorNameAndPublisher(String authorName, String publisher) throws sujalBookException;
	public void updateBookPrice(Integer bookId, Integer price) throws sujalBookException;
	public void deleteBook(Integer bookId) throws sujalBookException;

}
