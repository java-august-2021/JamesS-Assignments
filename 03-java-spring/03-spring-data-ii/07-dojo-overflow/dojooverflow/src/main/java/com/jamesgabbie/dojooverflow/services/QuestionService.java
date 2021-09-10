package com.jamesgabbie.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jamesgabbie.dojooverflow.models.Question;
import com.jamesgabbie.dojooverflow.models.Tag;
import com.jamesgabbie.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private QuestionRepository qRepo;

	public QuestionService(QuestionRepository qRepo) {
		this.qRepo = qRepo;
	}
	
	//Create
	public Question createQuestion(Question question) {
		return this.qRepo.save(question);
	}
	
	//Get One Question
	public Question getQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}

	//Get All Questions
	public List<Question> getAllQuestions(){
		return qRepo.findAll();
	}
	
	
	//Add Tags to Question
	public void addTagToQuestion(Question question, Tag tag) {
		question.getTags().add(tag);
		this.qRepo.save(question);
	}
	
}
