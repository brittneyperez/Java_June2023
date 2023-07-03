package com.javastack.burgertracker.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javastack.burgertracker.models.Burger;
import com.javastack.burgertracker.services.BurgerService;

@RestController
@RequestMapping("/api/burgers")
public class BurgerApiController {
	
	private final BurgerService burgerService;
	public BurgerApiController( BurgerService burgerService ) {
		this.burgerService = burgerService;
	}
	
	// READ ALL
	@RequestMapping("")
	public List<Burger> index() {
		return burgerService.allBurgers();
	}
	
	// CREATE
	@RequestMapping(value="", method=RequestMethod.POST)
	public Burger create(
			@RequestParam(value="name") String name,
			@RequestParam(value="restaurant") String restaurant,
			@RequestParam(value="rating") int rating,
			@RequestParam(value="notes") String notes
		) {
		Burger burger = new Burger(name, restaurant, rating, notes);
		return burgerService.createBurger(burger);
	}
	
	// READ ONE
	@RequestMapping("/{id}")
	public Burger show( @PathVariable("id") Long id ) {
		Burger burger = burgerService.findBurger(id);
		return burger;
	}
	
	// UPDATE
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Burger create(
			@PathVariable("id") Long id,
			@RequestParam(value="name") String name,
			@RequestParam(value="restaurant") String restaurant,
			@RequestParam(value="rating") int rating,
			@RequestParam(value="notes") String notes
		) {
		Burger burgerToUpdate = new Burger(name, restaurant, rating, notes);
		burgerToUpdate.setId(id);
		burgerToUpdate = burgerService.updateBurger(burgerToUpdate);
		return burgerToUpdate;
	}
	
	// DELETE
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete( @PathVariable("id") Long id ) {
		burgerService.deleteBurger(id);
	}
}
