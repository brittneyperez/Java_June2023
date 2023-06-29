package com.javaspringmvc.jpademo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javaspringmvc.jpademo.models.Book;
import com.javaspringmvc.jpademo.repositories.BookRepository;

@Service // connects controller to db
public class BookService {

	// Connection to Repository from Service
	// ? adding the book repository as a dependencyå
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// Method 1: uses repo method to Find All
	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	// Method 2: takes in book obj and uses it to save to db
	// creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	// Method 3: Optional obj is used to manage null values and searches for existing book
	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	
	// We can make our own methods to use methods from the repo:
	 public List<Book> booksContaining(String search) {
		return bookRepository.findByDescriptionContaining(search);
	 }
	 
	
	// Method 4: searches for existing primary key and applies changes
	// updates a book
	public Book updateBook(Book b) {
		return bookRepository.save(b);
	}
}
