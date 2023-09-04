package com.example.ReactDilrb.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ReactDilrb.entities.User;
import com.example.ReactDilrb.services.UserService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
	
	private UserService userService;
	
	
	@GetMapping("getallusers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("add")
	public User createUser(@RequestBody User newUser) {
		return userService.saveOneUser(newUser);
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		return userService.getOneUser(userId);
	}
	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId ,@RequestBody User newUser) {
		return userService.uptadeOneUser(userId,newUser);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteById(userId); 
	}

}
