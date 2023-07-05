package com.javastack.savetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javastack.savetravels.models.Expense;
import com.javastack.savetravels.services.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseApiController {
	// Connection to Service for Queries
	private final ExpenseService expenseService;
	public ExpenseApiController( ExpenseService expenseService ) {
		this.expenseService = expenseService;
	}
	
	// * READ ALL
	@RequestMapping("")
	public List<Expense> index() {
		return expenseService.allExpenses();
	}
	
	// * CREATE
	@RequestMapping(value="", method=RequestMethod.POST)
	public Expense create(
			@RequestParam(value="expenseName") String expenseName,
			@RequestParam(value="vendor") String vendor,
			@RequestParam(value="amount") double amount,
			@RequestParam(value="description") String description
			) {
		Expense expense = new Expense(expenseName, vendor, amount, description);
		return expenseService.createExpense(expense);
	}
	
	// * READ ONE
	@RequestMapping(value="/{id}")
	public Expense showExpense( @PathVariable("id") Long id ) {
		Expense expense = expenseService.findExpense(id);
		return expense;
	}
	
	// * UPDATE
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Expense update(
			@PathVariable("id") Long id,
			@RequestParam(value="expenseName") String expenseName,
			@RequestParam(value="vendor") String vendor,
			@RequestParam(value="amount") double amount,
			@RequestParam(value="description") String description
			) {
		Expense expenseToUpdate = new Expense(expenseName, vendor, amount, description);
		expenseToUpdate.setId(id);
		expenseToUpdate = expenseService.updateExpense(expenseToUpdate);
		return expenseToUpdate;
	}
	
	// * DELETE
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete( @PathVariable("id") Long id ) {
		expenseService.deleteExpense(id);
	}
}
