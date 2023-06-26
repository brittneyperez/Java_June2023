package com.javastack.hoppersreceipt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class HoppersReceiptApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoppersReceiptApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/receipt";
	}

}
