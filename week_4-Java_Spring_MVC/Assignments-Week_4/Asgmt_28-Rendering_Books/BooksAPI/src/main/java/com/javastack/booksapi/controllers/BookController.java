package com.javastack.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javastack.booksapi.models.Book;
import com.javastack.booksapi.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired // ? handles dependency injection
	BookService bookService;
	
	 @GetMapping("/test/{bookId}") // ? for testing purposes
	 public String test(
			  Model model, @PathVariable("bookId") Long bookId
		) {
		 System.out.printf("\nBookId: %s\n", bookId); // BookId: 4
		 Book testBook = bookService.findBook(bookId);
		 System.out.printf("Book Object: %s\n", testBook); // ? prints book as object
		 System.out.printf("Book Title: %s\n", testBook.getTitle()); // Book 4 Title: 你微笑时很美
		 
		 List<Book> bookList = bookService.allBooks();
		 model.addAttribute("books", bookList);
		 return "show.jsp";
	 }
	 
	 @GetMapping("/{bookId}")  // localhost:8080/books/1 will render 1st book in db
	 public String index( Model model, @PathVariable("bookId") Long bookId ) {
		 System.out.println("\nGenerating page for book of id: " + bookId);
		 
		 Book book = bookService.findBook(bookId);
		 System.out.printf("Book 4 Object: %s\n - %s\n - %s\n - %s\n", book.getTitle(), book.getDescription(), book.getLanguage(), book.getNumberOfPages());
		 model.addAttribute("book", book);
		 return "show.jsp";
	 }
}
