package com.javastack.burgertracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javastack.burgertracker.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger,Long> {
	
	// retrive all burgers from db
	List<Burger> findAll();
}
