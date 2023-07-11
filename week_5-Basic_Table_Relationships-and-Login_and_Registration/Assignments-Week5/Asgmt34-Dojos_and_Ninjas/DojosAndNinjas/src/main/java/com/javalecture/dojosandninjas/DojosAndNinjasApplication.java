package com.javalecture.dojosandninjas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class DojosAndNinjasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DojosAndNinjasApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/dojos";
	}
}
