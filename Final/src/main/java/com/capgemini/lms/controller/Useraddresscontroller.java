package com.capgemini.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.lms.constants.SuccessMessage;
import com.capgemini.lms.constants.UserAddressConstants;
import com.capgemini.lms.entities.UserAddress;
import com.capgemini.lms.exception.AddressNotFoundException;
import com.capgemini.lms.exception.ValidateAddressException;
import com.capgemini.lms.serviceimpl.UserAddressimpl;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Useraddresscontroller {
	@Autowired
    UserAddressimpl ua;
	@GetMapping(value="/userAddress")
	private List<UserAddress> viewUserAddressList(){
		return ua.viewUserAddressList();
	}
	@GetMapping("/userAddress/{id}")
	private UserAddress viewUserAddressList(@PathVariable("id") int UserAddressId) throws AddressNotFoundException{
		return ua.viewAddressByUserId(UserAddressId);
	}
	@DeleteMapping("/userAddress/{addressId}")
	private SuccessMessage deleteUserAddressDetails(@PathVariable("addressId") int addressId) throws AddressNotFoundException{
		ua.deleteUserAddress(addressId);
		 return new SuccessMessage(UserAddressConstants.ADDRESS_REMOVED);
	}
	@PostMapping("/userAddress")
	private SuccessMessage saveUserAddress(@RequestBody UserAddress address) throws AddressNotFoundException, ValidateAddressException {
		ua.addUserAddress(address);
		
		return new SuccessMessage(UserAddressConstants.ADDRESS_ADDED+ address.getAddressId());
		
	}
	@PutMapping("/updateAddress")
	private SuccessMessage updateUserAddressDetails(@RequestBody UserAddress address) throws AddressNotFoundException, ValidateAddressException {
		 ua.updateUserAddressDetails(address);
		 return new SuccessMessage(UserAddressConstants.ADDRESS_UPDATED+ address.getAddressId());
		
	}
}
	

