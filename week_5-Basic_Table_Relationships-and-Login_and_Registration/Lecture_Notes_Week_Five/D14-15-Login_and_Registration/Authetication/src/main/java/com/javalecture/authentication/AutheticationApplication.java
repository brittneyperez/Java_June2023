package com.javalecture.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class AutheticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutheticationApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/users";
	}
}
