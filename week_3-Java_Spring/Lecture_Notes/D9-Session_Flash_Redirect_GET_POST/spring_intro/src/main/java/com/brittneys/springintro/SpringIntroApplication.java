package com.brittneys.springintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class SpringIntroApplication { // This is where the main method lives

	public static void main(String[] args) {
		SpringApplication.run(SpringIntroApplication.class, args);
	}

	@RequestMapping("/hi") // annotations are how we define URLs
	public String indexD6() {
		return "Hello World!";
	}
	
	@RequestMapping("/") // this is to aid in rerouting in case user puts "/" instead of "/counting"
	public String index() {
		return "redirect:/counting";
	}
}
