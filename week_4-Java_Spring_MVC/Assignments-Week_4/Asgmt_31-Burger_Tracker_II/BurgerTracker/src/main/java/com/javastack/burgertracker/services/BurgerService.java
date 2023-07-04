package com.javastack.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javastack.burgertracker.models.Burger;
import com.javastack.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {

	// * Connection to Repository from Service - adding the burger repository as a dependency
	private final BurgerRepository burgerRepository;
	public BurgerService( BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	// READ ALL - return all burgers
	public List<Burger> allBurgers() {
		return burgerRepository.findAll();
	}
	
	// CREATE - take in burger obj and save to db, creating a burger
	public Burger createBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	// READ ONE - optional obj is used to manage null values and searchs for existing burger
	public Burger findBurger( Long id ) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		if (optionalBurger.isPresent()) {
			return optionalBurger.get();
		} else {
			return null;
		}
	}
	
	// UPATE - searches for existing burger by primary key and applies changes
	public Burger updateBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	// DELETE - delete exisiting burger by its primary key; deletes burger
	public void deleteBurger(Long id) {
		burgerRepository.deleteById(id);
	}
}
