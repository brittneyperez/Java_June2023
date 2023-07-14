package com.javalecture.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalecture.bookclub.services.BookService;
import com.javalecture.bookclub.services.UserService;

@Controller
@RequestMapping("/book-club")
public class MainController {
	
	@Autowired
	private UserService uService;
	@Autowired
	private BookService bookService;
	
	// Index
	@GetMapping("")
	public String index() {
		return "index.jsp";
	}
	
	// Register
	// Login
	
	// Dashboard
	@GetMapping("/books") 
	public String home() {
		return "home.jsp";
	}
	// Logout
	
	// **** Book Functionality *****
	// Add Book
	// Edit Book
	// Delete Book
}
