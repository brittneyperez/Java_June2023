package com.javastack.hoppersreceipt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// class definition and imports here...
@Controller
@RequestMapping("/receipt")
public class HopperController {
	
	@RequestMapping("")
	public String index(Model model) {
		
		// String name = "Grace Hopper";
		// String itemName = "Copper wire";
		// double price = 5.25;
		// String description = "Metal strips, also an illustration of nanoseconds.";
		// String vendor = "Little Things Corner Store";
		
		String name = "Janice Doe";
		String itemName = "iPad Mini";
		double price = 499.99;
		String description = "Tinier but Mightier.";
		String vendor = "Apple";
		
		model.addAttribute("customerName", name);
		model.addAttribute("itemName", itemName);
		model.addAttribute("itemPrice", price);
		model.addAttribute("itemDescription", description);
		model.addAttribute("itemVendor", vendor);
		return "index.jsp";
	}
}
