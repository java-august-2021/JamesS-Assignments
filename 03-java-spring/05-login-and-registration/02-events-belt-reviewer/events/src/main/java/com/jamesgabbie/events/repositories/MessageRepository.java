package com.jamesgabbie.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jamesgabbie.events.models.Event;
import com.jamesgabbie.events.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
	
	List<Message> findAll();
	List<Message> findAllByEvent(Event event);
	
}
