package com.brittneys.springintro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class PokeAPIController {
	
	@GetMapping("/test")
	public String test() {
		String test = "Testing... 1, 2, 3!";
		System.out.println(test);
		return test;
	}
	
	
	//* Add endpoints querying the API using @RequestParam & @PathVariable
	private RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("") // localhost:8080/api?pokemonName=pikachu
	public String getByName( @RequestParam(value="pokemonName") String pokeName ) {
		System.out.println(pokeName); //* Test route by harcoding pokemon name's first!
		String url = "https://pokeapi.co/api/v2/pokemon/" + pokeName; //* Todo: ADD URL for API & and use concatenation
		String output = restTemplate.getForObject(url, String.class);
		return output;
	}
	
	
	@GetMapping("/{pokeID}") // localhost:8080/api/8
	public String getByTypeId( @PathVariable("pokeID") Integer idNumber) {
		System.out.println(idNumber);
		String url = String.format("https://pokeapi.co/api/v2/type/%s", idNumber);
		String output = restTemplate.getForObject(url, String.class);
		return output;
	}
	
	
	@GetMapping("/{segmentOne}/{segmentTwo}") // localhost:8080/api/pokemon/jirachi
	public String getByInput(
			@PathVariable("segmentTwo") String segmentTwo, // name, type, etc.
			@PathVariable("segmentOne") String segmentOne // specifity
		) {
		System.out.printf("--- Specificity: %s - Name/Type: %s ---\n", segmentOne, segmentTwo); // i.e., pokemon - jirachi
		String url = String.format("https://pokeapi.co/api/v2/%s/%s", segmentOne, segmentTwo);
		String output = restTemplate.getForObject(url, String.class);
		return output;
	}
}
