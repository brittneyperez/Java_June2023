package com.javastack.projectmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javastack.projectmanager.models.User;
import com.javastack.projectmanager.services.ProjectService;
import com.javastack.projectmanager.services.UserService;
import com.javastack.projectmanager.validators.LoginUser;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/project-manager")
public class UserController {
	
	@Autowired
	private UserService uService;
	@Autowired
	private ProjectService pService;
	
	@GetMapping("")
	public String index(
			@ModelAttribute("newUser") User newUser,
			Model model
			) {
		model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
// Register ---------------------------------
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
		return "redirect:/project-manager/dashboard";
	}
// Login --------------------------------
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
		return "redirect:/project-manager/dashboard";
	}
	
// Dashboard - Shows all projects. ------
	@GetMapping("/dashboard") 
	public String home( Model model, HttpSession session ) {
		// Check if user is logged in, and if not, redirect to index page:
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		User currentUser = this.uService.findByUserById((Long) session.getAttribute("userId"));
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("unjoinedProjects", this.pService.getProjectsWithoutThisMember(currentUser));
		return "dashboard.jsp";
		}
// Logout -------------------------------
	@GetMapping("/logout")
	public String logout( HttpSession session ) {
		session.invalidate();
		System.out.println("\n$ See you soon!\n");
		return "redirect:/";
		}
}
