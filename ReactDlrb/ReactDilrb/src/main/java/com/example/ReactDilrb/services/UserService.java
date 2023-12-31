package com.example.ReactDilrb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ReactDilrb.entities.User;
import com.example.ReactDilrb.repos.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User saveOneUser(User newUser) {
		return userRepository.save(newUser);
	}

	public User getOneUser(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public User uptadeOneUser(Long userId, User newUser) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		}else
			return null;
	}

	public void deleteById(Long userId) {
		 userRepository.deleteById(userId);
		
	}

}
