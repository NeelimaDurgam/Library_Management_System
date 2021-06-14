package com.capgemini.lms.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.capgemini.lms.constants.UserConstants;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.UserNotFoundException;
import com.capgemini.lms.exception.ValidateUserException;
import com.capgemini.lms.service.UserService;
import com.capgemini.lms.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Usersimpl implements UserService{
	@Autowired
	UsersRepository userRepository;
	
	/*
	 * Add User Details
	 */
	@Override
	public Users register(Users user) throws UserNotFoundException, ValidateUserException {
		validateUser(user);
			return userRepository.save(user);
	}
	/*
	 * Add login Details
	 */
	@Override
	public Users loginValidate(int userid , String password) throws UserNotFoundException {
		//validateUser(new Users());
		try {
			if( password != null);
			return userRepository.save(new Users());
			}
		catch(Exception e) {
			throw new UserNotFoundException("The passed object cannot be null");
		}
	}
	/*
	 * Add User Details
	 */

	public void cancelSubscription(int userid) throws UserNotFoundException {
		Optional<Users> findUserById=userRepository.findById(userid);
		if(findUserById.isPresent()){
			userRepository.deleteById(userid);
		}
		else {
			throw new UserNotFoundException(UserConstants.USER_ID_NOT_FOUND);
		}
	}

	@Override
	public void payThePenalty(int userid, double amount) throws UserNotFoundException {
		try {
			userRepository.save(new Users());
		}catch(Exception e) {
			throw new UserNotFoundException("The passed object cannot be null");
		}
	}
	
	/*
	 * View All Users
	 */
	@Override
	public List<Users> viewAllUsers() {
		List<Users> result = new ArrayList<Users>();
        userRepository.findAll().forEach(User1 -> result.add(User1));
		return result;
	}
	
	/*
	 * Update User Details
	 */
	@Override
	public Users updateUserDetails(Users user) throws UserNotFoundException, ValidateUserException {
		validateUser(user);
		Optional<Users> findUserById=userRepository.findById(user.getUserid());
		if(findUserById.isPresent()){
				return userRepository.save(user);
		}
		else {
			throw new UserNotFoundException(UserConstants.USER_ID_NOT_FOUND);
		}
	}

	/*
	 * Remove User Details
	 */
	@Override
	public int deleteUser(int id) throws UserNotFoundException {
	Optional<Users> findUserById=userRepository.findById(id);
		if(findUserById.isPresent()){
				userRepository.deleteById(id);
			}
		else {
				throw new UserNotFoundException(UserConstants.USER_ID_NOT_FOUND);
		}
		return id;
	}
	
	/*
	 * Validating Inputs
	 */
public boolean validateUser(Users user) throws UserNotFoundException, ValidateUserException {
		
		if(!user.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
			throw new ValidateUserException(UserConstants.PASSWORD_CANNOT_BE_EMPTY);
		}

		if(!user.getFirstName().matches(UserConstants.NAME_PATTERN)) {
			throw new ValidateUserException(UserConstants.NAME_CANNOT_BE_EMPTY1);
		}
		if(!user.getLastName().matches(UserConstants.NAME_PATTERN)) {
			throw new ValidateUserException(UserConstants.NAME_CANNOT_BE_EMPTY2);
		}
		
		if(!user.getMobileno().matches("(0/91)?[7-9][0-9]{9}")) {
			throw new ValidateUserException(UserConstants.MOBILE_NUMBER_CANNNOT_BE_EMPTY);
		}
		if(!user.getEmail().matches("[A-Za-z0-9+_.-]+@(.+)$")) {
			throw new ValidateUserException(UserConstants.EMAIL_CANNOT_BE_EMPTY);
		}
		if(!user.getSubscription_date().matches("\\d{4}-\\d{2}-\\d{2}")) {
			throw new ValidateUserException(UserConstants.SUBSCRIPTION_DATE_CANNOT_BE_EMPTY);
		}
		if(!user.getSub_expire_date().matches(UserConstants.DATE_PATTERN)) {
			throw new ValidateUserException(UserConstants.SUB_EXPIRE_DATE_CANNOT_BE_EMPTY);
		}
		if(!user.getDate_of_birth().matches(UserConstants.DATE_PATTERN)) {
			throw new ValidateUserException(UserConstants.DATE_OF_BIRTH_CANNOT_BE_EMPTY);
		}
		if(!user.getSubscription_status().matches(UserConstants.NAME_PATTERN)) {
			throw new ValidateUserException(UserConstants.SUBSCRIPTION_STATUS_CANNOT_BE_EMPTY);
		}
		return true;
	}
}
