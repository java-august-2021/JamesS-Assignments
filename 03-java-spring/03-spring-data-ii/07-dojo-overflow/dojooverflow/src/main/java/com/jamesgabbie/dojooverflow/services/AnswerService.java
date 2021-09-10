package com.jamesgabbie.dojooverflow.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.jamesgabbie.dojooverflow.models.Answer;
import com.jamesgabbie.dojooverflow.models.Question;
import com.jamesgabbie.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	private AnswerRepository aRepo;
	public AnswerService(AnswerRepository aRepo) {
		this.aRepo = aRepo;
	}

	//Create
	public Answer createAnswer (Answer answer) {
		return this.aRepo.save(answer);
	}
	
	//Get Answers to Question
	public List<Answer> answersOfQuestion(Question question){
		return this.aRepo.findAllByQuestion(question);
	}
	

	
	
}
