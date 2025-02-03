package com.sujal.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sujal.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	List<Book> findAllByAuthorName(String authorName);
	List<Book> findAllByPriceGreaterThanEqual(Integer price);
	List<Book> findAllByPriceLessThanEqual(Integer price);
	List<Book> findAllByPublishedYearBetween(LocalDate fromDate,LocalDate toDate);
	List<Book> findAllByPublishedYearAfter(LocalDate date);
	List<Book> findAllByAuthorNameAndPublisher(String authorName, String Publisher);
}