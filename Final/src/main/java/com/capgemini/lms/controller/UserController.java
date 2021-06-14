package com.capgemini.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lms.constants.SuccessMessage;
import com.capgemini.lms.constants.UserConstants;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.UserNotFoundException;
import com.capgemini.lms.exception.ValidateUserException;
import com.capgemini.lms.serviceimpl.Usersimpl;

@RestController
public class UserController {
	 Usersimpl userImpl;
	@Autowired
	public UserController(Usersimpl userImpl) {
		this.userImpl = userImpl;
	}
	@GetMapping(value="/user")
	private List<Users> viewAllUsers(){
		return userImpl.viewAllUsers();
	}
	
	@DeleteMapping("/user/{id}")
	private SuccessMessage deleteUser(@PathVariable("id") int id) throws UserNotFoundException{
		 userImpl.deleteUser(id);
		 return new SuccessMessage(UserConstants.USER_REMOVED);
	}
	@PostMapping("/user")
	private SuccessMessage saveUser(@RequestBody Users user) throws UserNotFoundException, ValidateUserException {
		userImpl.register(user);
		return new SuccessMessage(UserConstants.USER_ADDED+user.getUserid());
	}
	@PutMapping("/updateUser")
	private SuccessMessage updateUserDetails(@RequestBody Users user) throws UserNotFoundException, ValidateUserException {
		userImpl.updateUserDetails(user);
		return new SuccessMessage(UserConstants.USER_UPDATED+user.getUserid());
	}
	
	
}
