package com.javastack.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javastack.savetravels.models.Expense;
import com.javastack.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	// Connection to Repository from Service - add ExpenseRepository as a dependency
	private final ExpenseRepository expenseRepository;
	public ExpenseService( ExpenseRepository expenseRepository ) {
		this.expenseRepository = expenseRepository;
	}
	
	// Method 1: Uses ExpenseService's findAll() to return all expenses from db
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	// Method 2: Takes in Expense obj and saves it to db
	public Expense createExpense( Expense expense ) {
		return expenseRepository.save(expense);
	}
	
	// Method 3: Optional obj used to manage null values and searches for existing expenses/retrieves expense
	public Expense findExpense( Long id ) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	// Method 4: Searches for existing expense by primary key and applies changes; updates expense with method similar to CREATE
	public Expense updateExpense( Expense expense ) {
		return expenseRepository.save(expense);
	}
	
	// Method 5: Deletes existing expense by primary key
	public void deleteExpense( Long id ) {
		expenseRepository.deleteById(id);
	}
}
