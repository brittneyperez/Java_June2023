package com.javalecture.beltreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class BeltReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeltReviewApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/users";
	}
}
