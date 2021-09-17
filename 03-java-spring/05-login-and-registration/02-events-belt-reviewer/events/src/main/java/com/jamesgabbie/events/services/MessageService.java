package com.jamesgabbie.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jamesgabbie.events.models.Event;
import com.jamesgabbie.events.models.Message;
import com.jamesgabbie.events.repositories.MessageRepository;

@Service
public class MessageService {
	private MessageRepository mRepo;
	public MessageService(MessageRepository mRepo) {
		this.mRepo = mRepo;
	}

	//Find All Messages
	public List<Message> getAll(){
		return this.mRepo.findAll();
	}
	
	//Create Message
	public Message createMessage(Message message) {
		return this.mRepo.save(message);
	}
	
	
	//Find all messages by event
	public List<Message> findMessages(Event event){
		return this.mRepo.findAllByEvent(event);
	}
}
