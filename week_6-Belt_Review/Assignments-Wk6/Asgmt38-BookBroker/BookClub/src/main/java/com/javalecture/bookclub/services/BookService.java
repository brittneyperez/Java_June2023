package com.javalecture.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalecture.bookclub.models.Book;
import com.javalecture.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	// Connection to Repository from Service
	@Autowired
	private BookRepository bookRepo;
	
	// * CREATE
	public Book addBook(Book newBook) {
		return bookRepo.save(newBook);
	}
	
	// * READ ALL
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
	// * READ ONE
	public Book getBookById( Long id ) {
		return this.bookRepo.findById(id).orElse(null);
	}
	
	// * UPDATE
	public Book updateBook( Book existingBook ) {
		return this.bookRepo.save(existingBook);
	}
	
	// * DELETE
	public void deleteBookById( Long id ) {
		this.bookRepo.deleteById(id);
	}
}