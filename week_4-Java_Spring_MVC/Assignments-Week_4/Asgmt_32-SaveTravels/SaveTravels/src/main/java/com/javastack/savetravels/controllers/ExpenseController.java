package com.javastack.savetravels.controllers;

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

import com.javastack.savetravels.models.Expense;
import com.javastack.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	// * READ 
	@GetMapping("")
	public String index( Model model ) {
		List <Expense> expenseBook = expenseService.allExpenses();
		model.addAttribute("expenses", expenseBook);
		model.addAttribute("expense", new Expense());
		
		System.out.println("\n------- Expense Book -------");
		for (int i=0; i<expenseBook.size();i++) {
			Expense expense = expenseBook.get(i);
			System.out.printf("%s %s | %s - $%.2f\n", i, expense.getExpenseName(), expense.getVendor(), expense.getAmount());
			System.out.println("------------------------------------------");
		}
		return "index.jsp";
	}
	
	// * CREATE
	@PostMapping("/addExpense")
	public String create(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result, Model model
			) {
		if (result.hasErrors()) {
			List<Expense> expenseBook = expenseService.allExpenses();
			model.addAttribute("expenses", expenseBook);
			return "index.jsp";
		}
		expenseService.createExpense(expense);
		return "redirect:/expenses";
	}
	
	// * READ ONE
	@GetMapping("/{expenseId}")
	public String showExpense(
			@PathVariable("expenseId") Long expenseId,
			Model model
			) {
		Expense expense = expenseService.findExpense(expenseId);
		model.addAttribute("expense", expense);
		return "read-one.jsp";
	}
	
	// * UPDATE
	@RequestMapping("/{id}/edit")
	public String editExpense(
			@PathVariable("id") Long id,
			Model model
			) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "update-form.jsp";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String update(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result, Model model
			) {
		if (result.hasErrors()) {
			model.addAttribute("expense", expense);
			return "/update-form.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/";
		}
	}
	
	// * DELETE
	@DeleteMapping("/{id}")
	public String deleteExpense( @PathVariable("id") Long id ) {
		expenseService.deleteExpense(id);
		return "redirect:/";
	}
}
