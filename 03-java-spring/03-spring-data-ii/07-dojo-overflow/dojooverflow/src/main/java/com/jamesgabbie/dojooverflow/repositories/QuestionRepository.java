package com.jamesgabbie.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jamesgabbie.dojooverflow.models.Answer;
import com.jamesgabbie.dojooverflow.models.Question;
import com.jamesgabbie.dojooverflow.models.Tag;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{

	
	List<Question> findAll();
	List<Question> findAllByTags(Tag tag);
	List<Question> findAllByAnswers(Answer answer);
}
