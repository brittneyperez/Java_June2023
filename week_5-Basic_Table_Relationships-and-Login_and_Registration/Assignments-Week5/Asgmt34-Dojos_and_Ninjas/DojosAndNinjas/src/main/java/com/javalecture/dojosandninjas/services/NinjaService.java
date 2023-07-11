package com.javalecture.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalecture.dojosandninjas.models.Ninja;
import com.javalecture.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	// Connection to Repo from Service
	@Autowired
	private NinjaRepository ninjaRepo; 
	
	// * CREATE
	public Ninja createNinja( Ninja newNinja ) {
		return this.ninjaRepo.save(newNinja);
	}
	
	// * READ ALL
	public List<Ninja> getAllNinjas() {
		return ninjaRepo.findAll();
	}
	
	// * READ ONE
	public Ninja getNinjaById( Long id ) {
		return this.ninjaRepo.findById(id).orElse(null);
	}
	
	// * UPDATE
	public Ninja updateNinja( Ninja updatedNinja ) {
		return this.ninjaRepo.save(updatedNinja);
	}
	
	// * DELETE
	public void deleteNinja( Long id ) {
		this.ninjaRepo.deleteById(id);
	}
}
