package com.brittneys.springintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class SpringIntroApplication { // This is where the main method lives

	public static void main(String[] args) {
		SpringApplication.run(SpringIntroApplication.class, args);
	}

	@RequestMapping("/") // annotations are how we define URLs
	public String index() {
		return "Hello World!";
	}
}
