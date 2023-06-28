package com.springintro.javaforms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
		// return "welcome.jsp";
	}
	
	//	@RequestMapping("/createError")
	//	public String flashMessage( RedirectAttributes redirectAttributes ) {
	//		redirectAttributes.addFlashAttribute("error", "This is a test error!");
	//		return "redirect:/";
	//	}
	
	
	@RequestMapping("/login") //* POST ROUTE - only handles logging in, not a landing page
	public String login(
			@RequestParam(value="email") String email,
			@RequestParam(value="password") String password,
			HttpSession session,
			RedirectAttributes redirectAttributes
		) { 
		/* GET vs POST
		 	Using GET is dangeroous because submitting a form leaves this data vulnarable: 
		 	http://localhost:8080/login?email=JaneDoe&password=hello 
		 	Use POST instead!
		 */
		
		if (password.length() < 5) {
			redirectAttributes.addFlashAttribute("error", "The password must be 5 or more characters!");
			return "redirect:/";
		}
		session.setAttribute("email", email);
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "welcome.jsp";
	}
}
