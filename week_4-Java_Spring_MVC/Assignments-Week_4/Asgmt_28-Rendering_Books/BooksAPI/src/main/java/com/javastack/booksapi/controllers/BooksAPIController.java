package com.javastack.booksapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javastack.booksapi.models.Book;
import com.javastack.booksapi.services.BookService;

@RestController // used when creating an API
public class BooksAPIController {
	
	// ? connects to Service
	private final BookService bookService;
	public BooksAPIController(BookService bookService){
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
			@RequestParam(value="description") String description,
			@RequestParam(value="language") String lang, 
			@RequestParam(value="pages") Integer numOfPages
		) {
		Book book = new Book(title, description, lang, numOfPages);
		return bookService.createBook(book);
	}
	
	
	@RequestMapping("/api/books/{id}")
	public Book show( @PathVariable("id") Long id ) {
		Book book = bookService.findBook(id);
		return book;
	}
	
	// updates an existing book and saves chnages to db
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	public Book update( // the PUT requests goes through these @PathVariables in the body to update each value
			@PathVariable("id") Long id,
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String description,
			@RequestParam(value="language") String lang,
			@RequestParam(value="numOfPages") Integer numOfPages
		) {
		// 								order of variables matter!!!
		Book bookToUpdate = new Book(title, description, lang, numOfPages);
		bookToUpdate.setId(id);
		bookToUpdate = bookService.updateBook(bookToUpdate);
		return bookToUpdate;
	}
	
	// deletes an existing book
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
}
