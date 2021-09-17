package com.jamesgabbie.events.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.jamesgabbie.events.models.Event;
import com.jamesgabbie.events.models.User;
import com.jamesgabbie.events.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository uRepo;

	public UserService(UserRepository uRepo) {
		this.uRepo = uRepo;
	}
	
	
	//All Users
	public List<User> allUsers(){
		return uRepo.findAll();
	}
	
	//Find User
	public User findUser(Long id) {
		Optional<User> optionalUser = uRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	
	// register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return uRepo.save(user);
    }
	
    // find user by email
    public User findByEmail(String email) {
        return uRepo.findByEmail(email);
    }

    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        User user = uRepo.findByEmail(email);
        if(user == null) {
            return false;
        } else {
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    //Find all joiners by event
    public List<User> findAllJoiners(Event event){
    	return uRepo.findJoinersByEvents(event);
    }
    


}

