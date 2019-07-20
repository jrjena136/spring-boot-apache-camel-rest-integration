package com.jyoti.spring.camel.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.jyoti.spring.camel.api.dto.Book;

@Service
public class BookService {
	private List<Book> books = new ArrayList<Book>();
	
	@PostConstruct
	public void initDB() {
		books.add(new Book("Author1", "Book1", new Date()));
		books.add(new Book("Author2", "Book2", new Date()));
		books.add(new Book("Author3", "Book3", new Date()));
	}
	public Book addBook(Book book) {
		books.add(book);
		return book;
	}

	public List<Book> getAllBooks() {
		return books;
	}
}
