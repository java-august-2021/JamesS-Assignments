package com.jamesgabbie.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jamesgabbie.dojooverflow.models.Question;
import com.jamesgabbie.dojooverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

	List<Tag> findAll();
	List<Tag> findAllByQuestions(Question question);
}
