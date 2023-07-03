package com.javastack.burgertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javastack.burgertracker.models.Burger;
import com.javastack.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/burgers")
public class BurgerController {
	
	@Autowired
	BurgerService burgerService;
	
	@GetMapping("")
	public String index( Model model ) {
		List<Burger> allBurgers = burgerService.allBurgers();
		model.addAttribute("burgers", allBurgers);
		model.addAttribute("burger", new Burger());
		
		System.out.println("\n---  ALL BURGERS  ---");
		for (int i=0; i<allBurgers.size(); i++) {
			Burger burger = allBurgers.get(i);
			System.out.printf("%s %s | %s | %s\n", i, burger.getName(), burger.getRestaurant(), burger.getRating());
			System.out.println("---------------------------------------");
		}
		return "index.jsp";
	}
	
	
	// * CREATE
	@PostMapping("/addBurger")
	public String create(
		    @Valid @ModelAttribute("burger") Burger burger,
		    BindingResult result, Model model
		) {
		if (result.hasErrors()) {
			List<Burger> allBurgers = burgerService.allBurgers();
			model.addAttribute("burgers", allBurgers);
			return "index.jsp";
		}
		burgerService.createBurger(burger);
		return "redirect:/burgers";
	}
	
	// * READ ONE
	// * UPDATE
	// * DELETE
}
