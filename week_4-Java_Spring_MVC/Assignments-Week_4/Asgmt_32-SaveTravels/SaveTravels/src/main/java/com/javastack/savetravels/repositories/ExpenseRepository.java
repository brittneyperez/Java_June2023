package com.javastack.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javastack.savetravels.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	
	// retrieves all expenses from db
	List<Expense> findAll();
}
