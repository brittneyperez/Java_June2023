package com.brittneys.springintro.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // to respond with view, but not data. place this at the class level
// RequestMapping for applicable object controller applies to
@RequestMapping("/view")
public class ViewController {
	
	@GetMapping("")
	public String view(Model viewModel) { // When returning file names, return it as a String.
		ArrayList<String> pizzaMenu = new ArrayList<String>();
		pizzaMenu.add("Pepperoni");
		pizzaMenu.add("Goat Cheese");
		pizzaMenu.add("Cheese");
		pizzaMenu.add("Hawaiian");
		pizzaMenu.add("Vegetable");
		pizzaMenu.add("Sausage");
		System.out.println(pizzaMenu); // [Pepperoni, Goat Cheese, Cheese, Vegetable, Sausage, Hawaiian]
		
		viewModel.addAttribute("pizza", "Pepperoni");
		viewModel.addAttribute("dfpizza", "Goat Cheese");
		viewModel.addAttribute("allPizzas", pizzaMenu);
		return "index.jsp";
	}
}
