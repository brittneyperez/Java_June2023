package com.javalecture.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalecture.dojosandninjas.models.Dojo;
import com.javalecture.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	// Connection to Repo from Service
	@Autowired
	private DojoRepository dojoRepo;
	
	// * CREATE
	public Dojo createDojo( Dojo newDojo ) {
		return this.dojoRepo.save(newDojo);
	}
	
	// * READ ALL
	public List<Dojo> getAllDojos() {
		return dojoRepo.findAll();
	}
	
	// * READ ONE
	public Dojo getDojoById( Long id ) {
		return this.dojoRepo.findById(id).orElse(null);
	}
	
	// * UPDATE
	public Dojo updateDojo( Dojo updatedDojo ) {
		return this.dojoRepo.save(updatedDojo);
	}
	
	// * DELETE
	public void deleteDojo( Long id ) {
		this.dojoRepo.deleteById(id);
	}
}
