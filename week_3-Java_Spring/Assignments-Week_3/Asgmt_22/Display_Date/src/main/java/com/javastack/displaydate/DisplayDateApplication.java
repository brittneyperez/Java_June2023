package com.javastack.displaydate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class DisplayDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayDateApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/home";
	}
}
