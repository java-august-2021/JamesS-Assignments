package com.jamesgabbie.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jamesgabbie.dojosandninjas.models.Dojo;
import com.jamesgabbie.dojosandninjas.models.Ninja;
import com.jamesgabbie.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private NinjaRepository ninjaRepo;
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}

	//Create
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
	
	//Update
	public Ninja updateNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
	
	//Destroy
	public void deleteNinja(Long id) {
		this.ninjaRepo.deleteById(id);
	}
	
	//Get One
	public Ninja getOneNinja(Long id) {
		return this.ninjaRepo.findById(id).orElse(null);
	}
	
	//Get All
	public List<Ninja> ninjasByDojo(Dojo dojo) {
		return this.ninjaRepo.findByDojo(dojo);
	}
}
