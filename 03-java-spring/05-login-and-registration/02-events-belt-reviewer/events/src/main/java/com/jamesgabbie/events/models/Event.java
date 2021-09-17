package com.jamesgabbie.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="Event name required")
    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NotNull(message="Date must be added")
    @Future(message="Date must be set in the future")
    private Date eventDate;
    @NotBlank(message="Location required")
    private String location;
    private String state;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @OneToMany(mappedBy="event", fetch=FetchType.LAZY)
    private List<Message> messages;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="joins", 
    	joinColumns = @JoinColumn(name="event_id"),
    	inverseJoinColumns = @JoinColumn(name="user_id"))
    private List<User> joiners;
    
    public Event() {
    	
    }
     
    
   

	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Date getEventDate() {
		return eventDate;
	}




	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public Date getCreatedAt() {
		return createdAt;
	}




	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}




	public Date getUpdatedAt() {
		return updatedAt;
	}




	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public List<Message> getMessages() {
		return messages;
	}




	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}




	public List<User> getJoiners() {
		return joiners;
	}




	public void setJoiners(List<User> joiners) {
		this.joiners = joiners;
	}




	public Event(String name, Date eventDate, String location, String state, User user, List<Message> messages, List<User> joiners) {
		this.name = name;
		this.eventDate = eventDate;
		this.location = location;
		this.state = state;
		this.user = user;
		this.messages = messages;
		this.joiners = joiners;
	}




	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
