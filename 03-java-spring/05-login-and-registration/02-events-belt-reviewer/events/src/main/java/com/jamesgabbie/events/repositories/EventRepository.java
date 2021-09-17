package com.jamesgabbie.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jamesgabbie.events.models.Event;
import com.jamesgabbie.events.models.User;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{

	List<Event> findAll();
	List<Event> findAllEventsByUser(User user);
	List<Event> findAllByState(String state);
	List<Event> findAllByStateNot(String state);
	
}
