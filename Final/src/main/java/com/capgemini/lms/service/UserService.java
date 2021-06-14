package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.UserNotFoundException;
import com.capgemini.lms.exception.ValidateUserException;

public interface UserService {
	public Users register(Users user) throws UserNotFoundException, ValidateUserException;
	public Users loginValidate(int userid,String password) throws UserNotFoundException;
	public void cancelSubscription(int userid) throws UserNotFoundException;
	public void payThePenalty(int userid, double amount) throws UserNotFoundException;
	public List<Users> viewAllUsers();
	public Users updateUserDetails(Users user) throws UserNotFoundException, ValidateUserException;
	public int deleteUser(int id) throws UserNotFoundException;
}
