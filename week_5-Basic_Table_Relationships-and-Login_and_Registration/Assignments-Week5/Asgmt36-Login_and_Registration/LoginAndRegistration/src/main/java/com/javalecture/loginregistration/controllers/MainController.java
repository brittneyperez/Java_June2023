package com.javalecture.loginregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalecture.loginregistration.models.User;
import com.javalecture.loginregistration.services.UserService;
import com.javalecture.loginregistration.validators.LoginUser;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/authenticate")
public class MainController {
	
	@Autowired
	private UserService uService;
	
	// * INDEX -- Login and Registration
	@GetMapping("")
	public String index(
			@ModelAttribute("newUser") User newUser, // Setting JavaBean for reloading RegisterForm object w/ validations. 
			Model model
			) {
		model.addAttribute("loginUser", new LoginUser()); // Setting JavaBean for reloading LoginForm object w/ validations.
		return "index.jsp";
	}
	
	// * POST ROUTES ------------
	// * REGISTER
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser") User registeringUser,
			BindingResult result, Model model, HttpSession session
			) {
		// 1 Call registerUser() method in uSerive to perfom extra validations when creating a user.
		User thisUser = this.uService.registerUser(registeringUser, result);
		// 2 If/when "null" is returned from uService.registerUser(), then return the form with validations.
		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser()); // Use JavaBean to maintain empty LoginUser obj in LoginForm. 
			return "index.jsp";
		}
		// 3 If BindingResult is valid, then save thisUser to db, store their id in session and log them in.  
		session.setAttribute("userId", thisUser.getId());
		return "redirect:/authenticate/home";
	}
	
	// * LOGIN
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("loginUser") LoginUser newLoginObject,
			BindingResult result, Model model, HttpSession session
			) {
		User thisUser = this.uService.loginUser(newLoginObject, result);
		if( result.hasErrors() ) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("userId", thisUser.getId());
		return "redirect:/authenticate/home";
	}
	
	
	// * DASHBOARD
	@GetMapping("/home")
	public String home( Model model, HttpSession session ) {
		Long userId = (long) session.getAttribute("userId");
		model.addAttribute("currentUser", this.uService.findUserById(userId));
		return "dashboard.jsp";
	}
	
	// * LOGOUT
	@GetMapping("/logout")
	public String logout( HttpSession session ) {
		session.invalidate();
		return "redirect:/";
	}
}
