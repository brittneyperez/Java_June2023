package com.javaspringmvc.jpademo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.javaspringmvc.jpademo.models.Book;
import com.javaspringmvc.jpademo.services.BookService;

@Controller
public class BookController {
	
	@Autowired // ? handles dependency injection
	BookService bookService;
	
	 @GetMapping("/books/{bookId}")
	 public String index( Model model, @PathVariable("bookId") Long bookId ) {
		 
		 // localhost:8080/books/3
		 System.out.println(bookId); // 3
		 Book bookVar = bookService.findBook(bookId); // ? finding the book with id=2
		 System.out.println(bookVar);
		 
		 List<Book> bookList = bookService.allBooks();
		 
		 model.addAttribute("book1", bookVar); // com.javaspringmvc.jpademo.models.Book@173adb91
		 model.addAttribute("books", bookList); // [com.javaspringmvc.jpademo.models.Book@390364d6,...]
		 
		 return "index.jsp";
	 }
}
