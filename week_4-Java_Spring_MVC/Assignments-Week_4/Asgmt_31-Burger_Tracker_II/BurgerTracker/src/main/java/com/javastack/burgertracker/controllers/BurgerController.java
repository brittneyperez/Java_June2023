package com.javastack.burgertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@GetMapping("/{burgerId}")
	public String showBurger(
			Model model,
			@PathVariable("burgerId") Long burgerId
			) {
		Burger burger = burgerService.findBurger(burgerId);
		model.addAttribute("burger", burger);
		System.out.printf("\nGenerating page for Burger with id %s...\n%s - %s\n-------------\n", burgerId, burger.getName(), burger.getRestaurant());
		return "read-one.jsp";
	}
	
	// * UPDATE
	@RequestMapping("/{id}/edit")
	public String editBurger(
			Model model,
			@PathVariable("id") Long id
			) {
		Burger burger = burgerService.findBurger(id);
		model.addAttribute("burger", burger);
		return "update-form.jsp";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String update(
			Model model,
			@Valid @ModelAttribute("burger") Burger burger,
			BindingResult result
			) {
		if (result.hasErrors()) {
			model.addAttribute("burger", burger);
			return "/update-form.jsp";
		} else {
			burgerService.updateBurger(burger);
			return "redirect:/";
		}
	}
	
	// * DELETE
	@DeleteMapping("/{id}")
	public String delete( @PathVariable("id") Long id ) {
		burgerService.deleteBurger(id);
		return "redirect:/";
	}
}
