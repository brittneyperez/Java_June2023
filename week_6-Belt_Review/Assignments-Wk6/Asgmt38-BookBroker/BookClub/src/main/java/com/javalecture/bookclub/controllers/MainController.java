package com.javalecture.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalecture.bookclub.models.Book;
import com.javalecture.bookclub.models.User;
import com.javalecture.bookclub.services.BookService;
import com.javalecture.bookclub.services.UserService;
import com.javalecture.bookclub.validators.LoginUser;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/book-club")
public class MainController {
	
	@Autowired
	private UserService uService;
	@Autowired
	private BookService bookService;
	
	// Index
	@GetMapping("")
	public String index(
			@ModelAttribute("newUser") User newUser,
			Model model
			) {
		model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
	// Register ---------------------
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser") User registeringUser,
			BindingResult result, Model model, HttpSession session
			) {
		// 1 Call uService.registerUser() method to perform extra validations when creating a user:
		User thisUser = this.uService.registerUser(registeringUser, result);
		// 2 If/when "null" is returned from uService.registerUser(), then return the form with validations:
		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		}
		// 3 If BindingResult is valid. then save thisUser to db and store their id in session and log them in:
		session.setAttribute("userId", thisUser.getId());
		System.out.printf("\n$ Welcome user, @user%s...\n", thisUser.getId());
		return "redirect:/book-club/books";
	}
	// Login ------------------------
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("loginUser") LoginUser newLoginObject,
			BindingResult result, Model model, HttpSession session
			) {
		// 1 Call uService.loginUser() method to perform extra validations when verifying a user:
		User thisUser = this.uService.loginUser(newLoginObject, result);
		// 2 If/when "null" is returned from uService.loginUser(), then return the form with validations:
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		// 3 If BindingResult is valid. then login thisUser and store their id in session:
		session.setAttribute("userId", thisUser.getId());
		System.out.printf("\n$ Welcome back user, @user%s...\n", thisUser.getId());
		return "redirect:/book-club/books";
	}
	
	// Dashboard - Shows all books.
	@GetMapping("/books") 
	public String home( Model model, HttpSession session ) {
		// Check if user is logged in, and if not, redirect to /book-club:
		if (session.getAttribute("userId") == null) {
			return "redirect:/book-club";
		}
		
		Long userId = (long) session.getAttribute("userId");
		User currentUser = this.uService.findByUserById(userId);
		
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("books", this.bookService.getAllBooks());
		return "home.jsp";
	}
	
	// Logout
	@GetMapping("/logout")
	public String logout( HttpSession session ) {
		session.invalidate();
		System.out.println("\n$ See you soon!\n");
		return "redirect:/";
	}
	
	
	// **** Book Functionality *****
	// Add Book ---------------------
	@GetMapping("/books/new") // set the Book obj to be able to use POST Method.
	public String addBook( @ModelAttribute("newBook") Book newBook ) {
		return "add-book.jsp";
	}
	
	@PostMapping("/books/create")
	public String createBookInDb(
			@Valid @ModelAttribute("newBook") Book newBook,
			BindingResult result, Model model, HttpSession session
			) {
		// If errors are present, re-render form with validation errors.
		if (result.hasErrors()) {
			return "add-book.jsp";
		}
		// Get the logged-in user's ID from the session
		Long userId = (Long) session.getAttribute("userId");
		// Find the user by ID from the database and set the reader attribute of the new book to the logged-in user
		User currentUser = this.uService.findByUserById(userId);
		newBook.setReader(currentUser);
	    
		// If there're no errors, do the additional validation and save to db
		if (newBook.getTitle() != null && !newBook.getAuthor().isEmpty() && !newBook.getThoughts().isEmpty()) {
		    bookService.addBook(newBook);
		}
		System.out.printf("\n# Adding book, %s, to shelf...\n", newBook.getTitle());
		return "redirect:/book-club/books";
	}
	
	// Show Book --------------------
	@GetMapping("/books/{id}")
	public String bookDetails(
			@PathVariable("id") Long id,
			Model model, HttpSession session
			) {
		Book selectedBook = this.bookService.getBookById(id); 
		model.addAttribute("book", selectedBook);
		
		// Check if the user is logged in, and add the currentUser attribute to the model if so.
		if (session.getAttribute("userId") != null) {
			Long userId = (Long) session.getAttribute("userId");
			User currentUser = this.uService.findByUserById(userId);
			model.addAttribute("currentUser", currentUser);
		}
		
		System.out.printf("\n# Loading page for book %s, %s...\n", id, selectedBook.getTitle());
		return "show-book.jsp";
	}
	
	// Edit Book --------------------
	@GetMapping("/books/{bookId}/edit")
	public String editBookDetails(
			@PathVariable("bookId") Long bookIdToEdit,
			Model model
			) {
		model.addAttribute("bookToEdit", this.bookService.getBookById(bookIdToEdit));
		return "edit-book.jsp";
	}
	
	@PutMapping("/books/{id}/update")
	public String editBook(
			@PathVariable("id") Long bookId,
			@Valid @ModelAttribute("bookToEdit") Book originalBook,
			BindingResult result, Model model, HttpSession session
			) {
		if (result.hasErrors()) {
			return "edit-book.jsp";
		}
		// Retrieve the reader's original book to edit:
		Book editedBook = this.bookService.getBookById(bookId);
		
		// Get the logged-in user's ID from the session
		Long userId = (Long) session.getAttribute("userId");
		User currentUser = this.uService.findByUserById(userId);
		
		/* Now that we found the user by their ID from the database, instead of 
		seting the reader attribute of the new book to the logged-in user as such:
		editedBook.setReader(currentUser); */
		
		// Update only the attributes that can be changed by the reader:
		editedBook.setTitle(originalBook.getTitle());
		editedBook.setAuthor(originalBook.getAuthor());
		editedBook.setThoughts(originalBook.getThoughts());
		
		// Then, set the reader attribute to the logged-in user:
		editedBook.setReader(currentUser);
		// Update the book in the db:
		this.bookService.updateBook(editedBook);
		
		System.out.printf("\n# Saving changes for book entry #%s, %s...\n", editedBook.getId(), editedBook.getTitle());
		return String.format("redirect:/book-club/books/%d", editedBook.getId());
	}
	
	
	// Borrow Book ------------------
	@GetMapping("/books/{bookId}/borrow")
	public String borrowBook(
			@PathVariable("bookId") Long id,
			HttpSession session
			) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/book-club/books";
		}
		Book borrowedBook = this.bookService.getBookById(id);
		// Retrive current user that's borrowing the book and set them as the borrower:
		Long userId = (Long) session.getAttribute("userId");
		User currentUser = this.uService.findByUserById(userId);		
		borrowedBook.setBorrower(currentUser);
		
		this.bookService.updateBook(borrowedBook);
		System.out.printf("\n# You are borrowing the book, %s...\n", borrowedBook.getTitle());
		return "redirect:/book-club/books";
	}
	
	// Return Book ------------------
	@GetMapping("/books/{bookId}/return")
	public String returnBook(
			@PathVariable("bookId") Long id,
			HttpSession session
			) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/book-club/books";
		}
		Book borrowedBook = this.bookService.getBookById(id);		
		borrowedBook.setBorrower(null);
		
		this.bookService.updateBook(borrowedBook);
		System.out.printf("\n# You are returning the book, %s...\n", borrowedBook.getTitle());
		return "redirect:/book-club/books";
	}
	
	// Delete Book
	@GetMapping("/books/{bookId}/delete")
	public String deleteBook(@PathVariable("bookId") Long bookId) {
		System.out.println("\nDeleting tweet "+ bookId +"...");
		this.bookService.deleteBookById(bookId);
		return "redirect:/book-club/books";
	}
}
