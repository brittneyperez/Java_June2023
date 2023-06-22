package com.codingdojo.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello") // this will limit repeating this same "/hello" route
public class HomeController {
	
	// These routes look similar to Python/Flask WebApps
	@RequestMapping("") // same as ("/")
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping("/my_route") // same as ("/hello/my_route")
	public String newRoute() {
		return "This is my first route in Java!";
	}
	
	@RequestMapping("/world") // same as ("/hello/world")
	public String world() {
		return "Class level annotations are cool too!";
	}
	
	@RequestMapping("/user")
	public String greet() {
		return "Hello user";
	}
	
	@RequestMapping("/goodbye/world")
	public String goodbyeWorld() {
		return "再见。Goodbye world!";
	}
    
}
