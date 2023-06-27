package com.javastack.fruityloops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javastack.fruityloops.models.Item;

@Controller
public class ItemController {
	
	@RequestMapping("/")
	public String index( Model model) {
		
		ArrayList<Item> fruitsBasket = new ArrayList<Item>();
		fruitsBasket.add(new Item("Kiwi", 1.5));
		fruitsBasket.add(new Item("Mango", 2.0));
		fruitsBasket.add(new Item("Goji Berries", 4.0));
		fruitsBasket.add(new Item("Guava", .75));
		fruitsBasket.add(new Item("Strawberry", 2.25));
		fruitsBasket.add(new Item("Banana", 0.25));
		fruitsBasket.add(new Item("Apple", 1.85));
		fruitsBasket.add(new Item("Blackberries", 4.75));
		// System.out.println(fruitsBasket); <= printed out as objects within an ArrayList
		
		System.out.println("\nFruit Store\n");
		for (int i = 0; i < fruitsBasket.size(); i++) {
			Item fruit = fruitsBasket.get(i);
			System.out.println("Item at index " + i + ":");
			System.out.printf("Name: %s -- $%.2f\n", fruit.getName(), fruit.getPrice());
			System.out.println("-----------------------------");
		}
		
		// Model         JSP variable  method variable
		model.addAttribute("fruits", fruitsBasket);
		
		return "index.jsp";
	}
}
