package com.jamesgabbie.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jamesgabbie.dojosandninjas.models.Dojo;
import com.jamesgabbie.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private DojoRepository dojoRepo;
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	//Create
	public Dojo createDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}

	//Update
	public Dojo updateDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
	
	//Destroy
	public void deleteDojo(Long id) {
		this.dojoRepo.deleteById(id);
	}
	
	//Get One
	public Dojo getOneDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
	
	//Get All
	public List<Dojo> getAll() {
		return this.dojoRepo.findAll();
	}

}
