package com.jamesgabbie.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jamesgabbie.dojooverflow.models.Question;
import com.jamesgabbie.dojooverflow.models.Tag;
import com.jamesgabbie.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	private TagRepository tRepo;
	public TagService(TagRepository tRepo) {
		this.tRepo = tRepo;
	}
	
	//Create
	public Tag createTag(Tag tag) {
		return this.tRepo.save(tag);
	}
	
	//Get All Tags
	public List<Tag> getAllTags(){
		return this.tRepo.findAll();
	}
	
	//Get one tag
	public Tag getTag(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	
	//Get Tags to Question
	public List <Tag> tagsOfQuestion(Question question){
		return this.tRepo.findAllByQuestions(question);
	}
	
	//Add Questions to Tag
	public void addQuestionToTag(Question question, Tag tag) {
		tag.getQuestions().add(question);
		this.tRepo.save(tag);
	}

}
