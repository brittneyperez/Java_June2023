package com.javalecture.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalecture.authentication.models.User;
import com.javalecture.authentication.services.UserService;
import com.javalecture.authentication.validators.LoginValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
	
	// Implement Service:
	@Autowired
	private UserService uService;
	
	// INDEX - Registration and Login Form
	@GetMapping("")
	public String index(
			@ModelAttribute("newUser") User newUser,
			Model model ) {
		// Bind empty User and loginUser objects to the JSP to capture the form input 
		model.addAttribute("loginUser", new LoginValidator()); // new LoginValidator() instantiates a new obj
		return "index.jsp";
	}
	/*! THE GET ROUTE THAT LOADS THE PAGE WITH THE FORM ALWAYS NEEDS TO MATCH EITHER
		THE @ModelAttribute("newUser") THAT WILL BE CALLED LATER OR model.addAttribute("newUser", new User());
		BEING USED TO RELOAD THE BEAN IN THE ERROR CODE BLOCK! 
		For example:
		We need to send in the empty LoginValidator before re-rendering the page because when errors 
		appear in the Register form, the login form will reload a new empty bean */
	
	// * CREATE -- REGISTER
	@PostMapping("/register")
	public String register( // All these params will be used to validate users
			@Valid @ModelAttribute("newUser") User userToRegister, // "newUser" is the modelAttribute that is in the form:form element.
			BindingResult result, Model model, HttpSession session
			) {
		
		// ① Calls register() method in the service to perform extra validations/create a new user.
		User registeringUser = this.uService.registerUser(userToRegister, result);
		// ② If/when null is returned from uService.register(), then the bottom will be performed to peresent the errors in the Front-End.
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginValidator()); // new User() instantiates a new User obj
			return "index.jsp";
		}
		// If there are no errors then uService will handle saving registeringUser to the db. 
		// TODO: Store their ID from the DB in session, in other words, log them in.
		session.setAttribute("userId", registeringUser.getId()); // retrieve the current user's id and save it to session to create a user-specific environment for them.
		return "redirect:/users/home"; // since this route is after register() we need to specify "/users/home" so this method can search it after register() finishes
    }
	
	// * LOGIN
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("loginUser") LoginValidator newLogin, // "newUser" is the modelAttribute that is in the form:form element.
			BindingResult result, Model model, HttpSession session
			) {
		// ❶ Calls loginUser() method in the Service to perform extra validations/find this user if they exist.
		User user = uService.loginUser(newLogin, result); // We are also sending in the binding results from the Login Form.
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User()); // refresh registration form
			return "index.jsp";
		}
		session.setAttribute("userId", user.getId()); // retrieve the current user's id and store in session to create a user-specific environment for them.
		return "redirect:/users/home";
	}
	
	// * DASHBOARD
	@GetMapping("/home")
	public String home( Model model, HttpSession session ) {
		Long userId = (long) session.getAttribute("userId");
		model.addAttribute("currentUser", this.uService.findUserById(userId));
		return "dashboard.jsp";
	}
	
	// * LOG OUT
	@GetMapping("/logout")
	public String logout( HttpSession session ) {
		session.invalidate();
		return "redirect:/";
	}
}
