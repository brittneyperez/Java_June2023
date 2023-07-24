package com.javalecture.beltreview.controllers;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalecture.beltreview.models.User;
import com.javalecture.beltreview.services.ProjectService;
import com.javalecture.beltreview.services.UserService;
import com.javalecture.beltreview.validators.LoginUser;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private ProjectService pService;
	@Autowired
	private UserService uService;
	
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
			return "redirect:/users/home";
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
			return "redirect:/users/home";
		}
		
		// Dashboard - Shows all projects. ------
		@GetMapping("/home") 
		public String home( Model model, HttpSession session ) {
			// Check if user is logged in, and if not, redirect to index page:
			if (session.getAttribute("userId") == null) {
				return "redirect:/";
			}
			
			User currentUser = this.uService.findByUserById((Long) session.getAttribute("userId"));
			model.addAttribute("currentUser", currentUser);
			model.addAttribute("unjoinedProjects", this.pService.getProjectsWithoutThisMember(currentUser));
			return "home.jsp";
		}
		
		
		// About Me -----------------------------
		@GetMapping("/about")
		public String aboutMe(
				@RequestParam("user") Long userId,
				Model model, HttpSession session
			) {
			// Check if the requested user ID matches the logged-in user's ID, and if not, redirect to index page:
		    Long loggedInUserId = (Long) session.getAttribute("userId");
		    if (loggedInUserId == null || !loggedInUserId.equals(userId)) {
		        return "redirect:/users";
		    }
			User currentUser = this.uService.findByUserById(userId);
			
			// Calculate age:
			LocalDate currentDate = LocalDate.now();
			int userAge = Period.between(currentUser.getDateOfBirth(), currentDate).getYears();
			
			// Format DOB:
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
			String formattedDOB = currentUser.getDateOfBirth().format(dateFormatter);
			
			model.addAttribute("currentUser", currentUser);
			model.addAttribute("userDOB", formattedDOB);
			model.addAttribute("age", userAge);
			return "about-me.jsp";
		}
		
		// Logout -------------------------------
		@GetMapping("/logout")
		public String logout( HttpSession session ) {
			session.invalidate();
			System.out.println("\n$ See you soon!\n");
			return "redirect:/";
		}
}
