package com.example.janssonbookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	// NOTE! Spring boot software will NOT accept private int id;

	private String title;
	private String author;
	private String isbn;
	private long publicationYear;
	private long price;

	public Book() {
		super();
	}

	// Mandatory for Spring boot. Without constructor + parameters,
	// then Spring boot will crash.
	public Book(String title, String author, String isbn, long publicationYear, long price) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public long getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(long publicationYear) {
		this.publicationYear = publicationYear;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}
