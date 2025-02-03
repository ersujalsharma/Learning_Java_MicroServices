package com.sujal.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	private Integer bookId;
	@Column(name="book_name")
	private String title;
	private String authorName;
	@Column(name="year")
	private LocalDate publishedYear;
	private String publisher;
	private Long isbn;
	private Integer price;
	public Integer getBookId() {
		return bookId;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public LocalDate getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(LocalDate publishedYear) {
		this.publishedYear = publishedYear;
	}
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
