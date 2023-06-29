package com.javaspringmvc.jpademo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringmvc.jpademo.models.Book;
import com.javaspringmvc.jpademo.services.BookService;

@RestController // used when creating an API
public class BooksAPI {
	
	// ? connects to Service
	private final BookService bookService;
	public BooksAPI(BookService bookService){
		this.bookService = bookService;
	}
	
	// retrieves books in db
	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}
	
	// creates a book obj to save to db
	@RequestMapping(value="/api/books", method=RequestMethod.POST)
	public Book create(
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String desc,
			@RequestParam(value="language") String lang, 
			@RequestParam(value="pages") Integer numOfPages
		) {
		Book book = new Book(title, desc, lang, numOfPages);
		return bookService.createBook(book);
	}
	
	
	@RequestMapping("/api/books/{id}")
	public Book show( @PathVariable("id") Long id ) {
		Book book = bookService.findBook(id);
		return book;
	}
}
