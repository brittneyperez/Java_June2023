package com.springintro.javaforms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	// * POST ROUTE - only handles logging in, not a landing page
	@RequestMapping("/login")
	public String login(
			@RequestParam(value="email") String email,
			@RequestParam(value="password") String password,
			HttpSession session
		) { 
		/* GET vs POST
		 	Using GET is dangeroous because submitting a form leaves this data vulnarable: 
		 	http://localhost:8080/login?email=JaneDoe&password=hello 
		 	Use POST instead!
		 */
		session.setAttribute("email", email);
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "welcome.jsp";
	}
}
