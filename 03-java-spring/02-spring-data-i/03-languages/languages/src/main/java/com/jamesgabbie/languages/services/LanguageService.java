package com.jamesgabbie.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jamesgabbie.languages.models.Language;
import com.jamesgabbie.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository repo;
	
	public LanguageService(LanguageRepository repo) {
		this.repo = repo;
	}
	
	//Create
	public Language create(Language language) {
		return this.repo.save(language);
	}
	//Update
	public Language update(Language language) {
		return this.repo.save(language);
	}
	//Destroy
	public void deleteById(Long id) {
		this.repo.deleteById(id);
	}
	//GetAll
	public List<Language> getAll() {
		return this.repo.findAll();
	}
	//Get One
	public Language getOne(long id) {
		return this.repo.findById(id).orElse(null);
	}
	

	
	
}
