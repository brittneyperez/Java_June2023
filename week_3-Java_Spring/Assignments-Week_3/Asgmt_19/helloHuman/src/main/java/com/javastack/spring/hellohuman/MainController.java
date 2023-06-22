package com.javastack.spring.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class MainController {

	// ① 'Hello Human' should be displayed if no name is provided in the URL.
	// ② 'Hello Khoa' should be displayed if 'Khoa' is provided in the URL. This should also work with any other names. 
	@RequestMapping("")
	public String hello( @RequestParam(value="name", required=false) String name ) { // ex: localhost:8080/hello?name=Khoa
		if (name!=null) {
			return "Hello " + name;
		}
		return "Hello Human";
	}
	
	// ③ 忍者Bonus: Include a "last_name" as a parameter and print out both the first and last names.
	@RequestMapping("/fullname")
	public String hello2( // ex: localhost:8080/hello/fullname?first_name=Khoa&last_name=Le
			@RequestParam(value="first_name", required=false) String firstName,
			@RequestParam(value="last_name", required=false) String lastName
		) { 
		if ( firstName != null && lastName != null) {
			return "Hello " + firstName + " " + lastName;
		} else if ( firstName != null ) {
			return "Hello " + firstName;
		} else {
			return "Hello Human";
		}		
	}
	
	// ④ 忍者Bonus: Add a "times" parameter and show the greeting that many times.
	@RequestMapping("/repeat")
	public String hello3( // ex: localhost:8080/hello/repeat?fName=Khoa&lName=Le&times=3
			@RequestParam(value="fName", required=false) String fName,
			@RequestParam(value="lName", required=false) String lName,
			@RequestParam(value="times", required=false) Integer times
		) {
		if (times != null && times > 0) {
			StringBuilder output = new StringBuilder(); //? Creating an instance of StringBuilder
			for (int i=0; i<times; i++) { //? based on the arguments given, the greeting will append to the string however many times are set
				if(fName != null && lName != null) {
					output.append("Hello ").append(fName).append(" ").append(lName).append(" ");
				} else if (fName != null) {
					output.append("Hello ").append(fName).append(" ");
				} else if (lName != null) {
					output.append("Hello ").append(lName).append(" ");
				} else {
					output.append("Hello Human ");
				}
			}
			return output.toString(); //? result is a string based on arguments given
		}
		
		if (fName != null && lName != null) {
			return "Hello " + fName + " " + lName;
		} else if (fName != null) {
			return "Hello " + fName;
		} else if (lName != null) {
			return "Hello " + lName;
		}
		return "Hello Human";
	}
}
