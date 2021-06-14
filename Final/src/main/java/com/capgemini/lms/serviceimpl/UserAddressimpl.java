package com.capgemini.lms.serviceimpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.constants.UserAddressConstants;
import com.capgemini.lms.entities.UserAddress;
import com.capgemini.lms.exception.AddressNotFoundException;
import com.capgemini.lms.exception.ValidateAddressException;
import com.capgemini.lms.repository.UserAddressRepository;
import com.capgemini.lms.service.UserAddressService;

@Service
public class UserAddressimpl implements UserAddressService{
	@Autowired
	UserAddressRepository useraddressrepository;
	
	/*
	 * Add UserAddress Details
	 */
	@Override
	public UserAddress addUserAddress(UserAddress address) throws  AddressNotFoundException, ValidateAddressException {
			validateAddress(address);
		return useraddressrepository.save(address);
		}
	
	/*
	 * Update UserAddress Details
	 */
	@Override
	public UserAddress updateUserAddressDetails(UserAddress address) throws AddressNotFoundException, ValidateAddressException{
		validateAddress(address);
		Optional<UserAddress> findUserById=useraddressrepository.findById(address.getAddressId());
		if(findUserById.isPresent()){
			useraddressrepository.save(address);
		}else {
            throw new AddressNotFoundException("The id doesn't exists.");
        }
		return address;
	}
	
	/*
	 * Remove UserAddress Details
	 */
	@Override
	public int deleteUserAddress(int addressId) throws AddressNotFoundException {
		Optional<UserAddress> findUserById=useraddressrepository.findById(addressId);
		if(findUserById.isPresent()){
			useraddressrepository.deleteById(addressId);
		} else {
			throw new AddressNotFoundException("The id doesn't exists.");
		}
		return addressId;
	}
	
	/*
	 * View Address by Id
	 */
	@Override
	public UserAddress viewAddressByUserId(int userid) throws AddressNotFoundException {
		try {
			return useraddressrepository.findById(userid).get();
		}catch(Exception e) {
			throw new AddressNotFoundException("The object cannot be null");
		}
	}
	
	/*
	 * View All Addresses
	 */
	@Override
	public List<UserAddress> viewUserAddressList() {
		List<UserAddress> result = new ArrayList<UserAddress>();
        useraddressrepository.findAll().forEach(UserAddress1 -> result.add(UserAddress1));
        return result;
	}
	
	/*
	 * Validating Inputs
	 */
	public boolean validateAddress(UserAddress address ) throws ValidateAddressException {
		if (!address.getAddress1().matches("[A-Za-z0-9]{1,7}")) {
			throw new ValidateAddressException(UserAddressConstants.ADDRESS_CANNOT_BE_EMPTY);
		}
		if (!address.getAddress2().matches("[A-Za-z0-9]{1,7}")) {
			throw new ValidateAddressException(UserAddressConstants.ADDRESS_CANNOT_BE_EMPTY);
		}
		if (!address.getCity().matches(UserAddressConstants.ADDRESS_PATTERN)) {
			throw new ValidateAddressException(UserAddressConstants.CITY_CANNOT_BE_EMPTY);
		}
		if (!address.getState().matches(UserAddressConstants.ADDRESS_PATTERN)) {
			throw new ValidateAddressException(UserAddressConstants.STATE_CANNOT_BE_EMPTY);
		}
		if (!address.getPincode().matches("[1-9][0-9]{5}")) {
			throw new ValidateAddressException(UserAddressConstants.PINCODE_CANNOT_BE_EMPTY);
		}
		return true;
	}
}
