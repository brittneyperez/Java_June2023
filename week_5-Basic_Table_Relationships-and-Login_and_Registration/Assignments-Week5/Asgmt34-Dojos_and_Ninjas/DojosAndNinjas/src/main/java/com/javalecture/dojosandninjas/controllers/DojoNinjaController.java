package com.javalecture.dojosandninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalecture.dojosandninjas.models.Dojo;
import com.javalecture.dojosandninjas.models.Ninja;
import com.javalecture.dojosandninjas.services.DojoService;
import com.javalecture.dojosandninjas.services.NinjaService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/dojos")
public class DojoNinjaController {
	
	// Services
	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;
	
	// * READ ALL
	@GetMapping("")
	public String index( Model model ) {  
		List<Dojo> allDojos = dojoService.getAllDojos();
		model.addAttribute("dojos", allDojos); // to retrieve dojos for DojoList in index
		model.addAttribute("dojo", new Dojo()); // Java Bean to render the page with new DojoForm
		
		System.out.println("\n----------- All Dojos -----------");
		for (int i=0; i<allDojos.size();i++) {
			Dojo singleDojo = allDojos.get(i);
			System.out.printf("%s  %s\n", i, singleDojo.getName());
			System.out.println("----------------------------------");
		}
		return "index.jsp";
	}
	
	// * CREATE -- Add Dojo
	@PostMapping("/add")
	public String addDojo(
			@Valid @ModelAttribute("dojo") Dojo newDojo,
			BindingResult result, Model model, HttpSession session
			) {
		// If errors exist, re-render page if there are errors in form submission.
		if (result.hasErrors()) {
			List<Dojo> allDojos = dojoService.getAllDojos();
			model.addAttribute("dojos", allDojos);
			return "index.jsp";
		}
		// If there is no errors, do this additional validation and save to db.
		if (newDojo.getName() != null && !newDojo.getName().isEmpty()) {
			dojoService.createDojo(newDojo);
		}
		System.out.printf("\nAdding dojo, %s...\n", newDojo.getName());
		return "redirect:/dojos";
	}
	
	// * CREATE -- Enroll Ninja
	@PostMapping("/enrolling")
	public String enrollNinja(
			@Valid @ModelAttribute("newNinja") Ninja newNinja,
			BindingResult result, Model model
			) {
		if (result.hasErrors()) { // If errors, refresh form but maintaining the list of dojos 
			model.addAttribute("dojosList", this.dojoService.getAllDojos());
			return "enroll-ninja.jsp";
		}
		
		newNinja = this.ninjaService.createNinja(newNinja);
		System.out.printf("\nAdding %s %s, age %syo, to %s...\n", newNinja.getFirstName(), newNinja.getLastName(), newNinja.getAge(), newNinja.getDojo().getName());
		return "redirect:/dojos/" + newNinja.getDojo().getId() + "/show";
		// return "redirect:/"; //? redirects to index page
	}
	
	// * READ ONE -- Ninja Form
	@GetMapping("/enroll/ninja")
	public String ninjaForm( Model model ) {
		model.addAttribute("newNinja", new Ninja()); // if validations are triggered, we need a new Ninja object available to use to be able to save to db
		model.addAttribute("dojosList", this.dojoService.getAllDojos()); // retrieves the dojosList to be able to use select in the form
		return "enroll-ninja.jsp";
	}
	
	// * READ ONE (Dojo)
	@GetMapping("/{id}/show")
	public String showDojoNinjas(
			@PathVariable("id") Long id,
			Model model
			) {
		
		System.out.printf("\nQuerying ninjas from dojo %s...\n", id);
		Dojo currentDojo = this.dojoService.getDojoById(id);
		model.addAttribute("dojo", currentDojo);
		model.addAttribute("theseNinjas", currentDojo.getTrainingNinjas());
		return "show-dojo.jsp";
	}
	
	// * UPDATE (Dojo)
	// * UPDATE (Ninja)
	
	// * DELETE (Dojo)
	// * DELETE (Ninja)
	
}
