package com.jamesgabbie.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jamesgabbie.dojooverflow.models.Answer;
import com.jamesgabbie.dojooverflow.models.Question;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{

	
	List<Answer> findAll();
	List<Answer> findAllByQuestion(Question question);
}
