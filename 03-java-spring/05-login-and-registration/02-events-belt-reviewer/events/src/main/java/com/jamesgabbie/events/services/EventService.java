package com.jamesgabbie.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jamesgabbie.events.models.Event;
import com.jamesgabbie.events.models.User;
import com.jamesgabbie.events.repositories.EventRepository;

@Service
public class EventService {
	private EventRepository eRepo;
	public EventService(EventRepository eRepo) {
		this.eRepo = eRepo;
	}
	
	//All Events  
	public List<Event> getAll(){
		return eRepo.findAll();
	}
	
	//Find Event
	public Event findEvent(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}

	//Create Event
	public Event createEvent(Event event) {
		return this.eRepo.save(event);
	}
	
	//Destroy Event
	public void deleteEvent(Long id) {
		this.eRepo.deleteById(id);
	}
	
	//Update Event
	public Event updateEvent(Event event) {
		return this.eRepo.save(event);
	}

	//Add Joiner
	public void addJoiner(Event event, User user) {
		List<User> currentJoiners = event.getJoiners();
		currentJoiners.add(user);
		this.eRepo.save(event);
	}
	
	//Remove Joiner
	public void removeJoiner(Event event, User user) {
		List<User> currentJoiners = event.getJoiners();
		currentJoiners.remove(user);
		this.eRepo.save(event);
	}
	
	//Find Events by UserCreater
	public List<Event> userEvents(User user){
		return eRepo.findAllEventsByUser(user);
	}
	// Find Events In State
	public List <Event> findEventByState(String state){
		return eRepo.findAllByState(state);
	}
	//Find Events NOT in State
	public List <Event> findEventsNotInState(String state){
		return eRepo.findAllByStateNot(state);
	}
}
