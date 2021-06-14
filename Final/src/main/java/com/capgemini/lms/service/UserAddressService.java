package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.entities.UserAddress;
import com.capgemini.lms.exception.AddressNotFoundException;
import com.capgemini.lms.exception.ValidateAddressException;


public interface UserAddressService {
	public UserAddress addUserAddress(UserAddress address) throws AddressNotFoundException, ValidateAddressException;
	public UserAddress updateUserAddressDetails(UserAddress address) throws AddressNotFoundException, ValidateAddressException;
	public int deleteUserAddress(int addressId) throws AddressNotFoundException;;
	public UserAddress viewAddressByUserId(int userid) throws AddressNotFoundException;;
	public List<UserAddress> viewUserAddressList();
}
