package com.daikichi.pathvariables.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	
	@RequestMapping("")
	public String welcome() {
		return "Welcome to Daikichi Path Variables!";
	}
	
	// ① Have an http GET request to 'http://localhost:8080/daikichi/travel/kyoto' where the URL will take any string for the city and display a text that says 
	@RequestMapping("/travel/{cityVariable}")
	public String travel( @PathVariable("cityVariable") String city ) {
		System.out.println(city);
//		return "Congratulations! You will soon travel to " + city + "!";
		return String.format("Congratulations! You will soon travel to %s!", city);
	}
	
	// ② Have an http GET request to 'http://localhost:8080/daikichi/lotto/8', where the URL will take any integer. If the number is even, display a text that says:
	@RequestMapping("/lotto/{number}")
	public String lotto( @PathVariable("number") int number) {
		if (number % 2 == 0) { // if: even
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
		} else { // else: odd
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";			
		}
	}
}
