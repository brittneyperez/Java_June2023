package com.brittneys.springintro.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class APIController { // This is the REST Controller
	
	// Below these are considered function/method level mappings
	// To avoid repetition, we can define the repeating URL path above.
	@RequestMapping("")
	public String index() {
		return "Hello user!";
	}
	
	// you can be explicit about the request as well
	@RequestMapping( value="/hello", method=RequestMethod.GET )
	public String hello( // localhost:8080/greeting/name?firstName=Jane&lastName=Doe
			@RequestParam(value="firstName", required=false) String fname,
			@RequestParam(value="lastName", required=false) String lname
		) {
		System.out.print(fname); // prints the value we give for the param
		System.out.print(lname);
		if (fname == null || lname == null) {
			return "Hello World!";
		}
		return String.format("Hello %s %s! Thank you for visiting me:)", fname, lname);
	}
	
	@RequestMapping("/goodbye/{incomingNumber}/{incomingString}")
	public String world( // localhost:8080/greeting/goodbye/100/jane
			@PathVariable("incomingNumber") Integer num,
			@PathVariable("incomingString") String myString
		) { // has to be a Wrapper class, not a primitive
		System.out.println(num);
		System.out.println(myString);
//		String output = "";
//		for (int i=0; i<=num; i++) {
//			output += "Goodbye World";
//		}
//		return output;
		return myString.repeat(num);
	}
	
	

}
