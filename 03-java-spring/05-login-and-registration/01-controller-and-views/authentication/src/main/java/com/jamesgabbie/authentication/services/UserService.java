package com.jamesgabbie.authentication.services;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.jamesgabbie.authentication.models.User;
import com.jamesgabbie.authentication.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository uRepo;
	public UserService(UserRepository uRepo) {
		this.uRepo = uRepo;
	}
	
	
	//register User and Hash Password
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return uRepo.save(user);
	}
	
	//find user by email
	public User findByEmail(String email) {
		return uRepo.findByEmail(email);
	}
	
	//find user by id
	public User findUserById(Long id) {
		Optional<User> u = uRepo.findById(id);
		if(u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}
	
	//authenticate user
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
	
}
