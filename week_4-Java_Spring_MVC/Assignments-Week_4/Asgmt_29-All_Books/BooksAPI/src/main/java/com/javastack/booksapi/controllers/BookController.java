package com.javastack.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javastack.booksapi.models.Book;
import com.javastack.booksapi.services.BookService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired // ? handles dependency injection
	BookService bookService;
	
	// * READ ALL
	@GetMapping("") // Displays all books
	public String index( Model model ) {
		List<Book> bookList = bookService.allBooks();
		
		System.out.println("\n--- ALL BOOKS ---");
		for( int i=0; i<bookList.size(); i++ ) {
			Book book = bookList.get(i);
			System.out.printf("id: %s | %s | %s | %s pgs\n", i, book.getTitle(), book.getLanguage(), book.getNumberOfPages());
			System.out.println("---------------------------------------");
		}
		model.addAttribute("books", bookList);
		return "index.jsp";
	}
	
	// * CREATE
	@GetMapping("/new") // renders create form
	public String createForm( @ModelAttribute("book") Book book ) {
		return "create-form.jsp";
	}
	
	@PostMapping("") // this POST route is the create form's action and method to add new book to db
	public String create( 
			@ModelAttribute("book") @Valid Book book, // ModelAttribute will also be present in the form to create an obj of new book via POST method
			BindingResult result // this will aid in collecting errors
			) {
		if (result.hasErrors()) {
			return "create-form.jsp";
		}
		bookService.createBook(book);
		return "redirect:/books";
	}
	
	// * READ ONE
	@GetMapping("/{bookId}")  // localhost:8080/books/1 will render 1st book in db
	public String showDetails( Model model, @PathVariable("bookId") Long bookId ) {
		System.out.println("\nGenerating page for book of id: " + bookId + "...");
		
		Book book = bookService.findBook(bookId);
		System.out.printf("%s\n - %s\n - %s\n - %s\n", book.getTitle(), book.getDescription(), book.getLanguage(), book.getNumberOfPages());
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
	// * UPDATE
	@RequestMapping("/{id}/edit")
	public String edit( @PathVariable("id") Long id, Model model ) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "/edit.jsp";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String update(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			Model model
			) {
		if (result.hasErrors()) {
			model.addAttribute("book", book);
			return "/edit.jsp";
		} else {
			bookService.updateBook(book);
			return "redirect:/";
		}
	}
	
	// * DELETE - longhand
//	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
//	public String delete( @PathVariable("id") Long id ) {
//		bookService.deleteBook(id);
//		return "redirect:/";
//	}
	
	// * DELETE - shorthand
	@DeleteMapping("/{id}")
	public String delete( @PathVariable("id") Long id ) {
		bookService.deleteBook(id);
		return "redirect:/";
	}
}
