package com.jamesgabbie.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jamesgabbie.events.models.Event;
import com.jamesgabbie.events.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User findByEmail(String email);
	List<User> findAll();
	List<User> findJoinersByEvents(Event event);

	
}
