package com.capgemini.lms.serviceimpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.constants.ReaderConstants;
import com.capgemini.lms.entities.Reader;
import com.capgemini.lms.exception.ReaderNotFoundException;
import com.capgemini.lms.exception.ValidateReaderException;
import com.capgemini.lms.service.ReaderService;
import com.capgemini.lms.repository.ReaderRepository;
import com.capgemini.lms.serviceimpl.*;

@Service
public class ReaderServiceImpl implements ReaderService {
	@Autowired
	ReaderRepository readerRepo;
	
	/*
	 * Registering Reader
	 */

	@Override
	public Reader register(Reader reader) throws ReaderNotFoundException, ValidateReaderException {
		if(validateReader(reader) == true) {
			readerRepo.save(reader);
		}
		else {
			throw new ValidateReaderException("Please input date properly");
		}
		
		return reader;
	
	}
	
	/*
	 * Updating the reader details
	 */

	@Override
	public Reader updateReaderDetails(Reader reader) throws ReaderNotFoundException, ValidateReaderException {
		Optional<Reader> readers = readerRepo.findById(reader.getId());
		if(readers.isPresent() && validateReader(reader) == true) {
			return readerRepo.save(reader);
			
		}
		else {
			throw new ReaderNotFoundException("Reader with ID : " + reader.getId() + " doesn't exist");
		}
		
		}
    
	/*
	 * Deleting Reader details by Id
	 */
	@Override
	public int deleteReader(int id) throws ReaderNotFoundException {
		Optional<Reader> reader = readerRepo.findById(id);
		if(!reader.isPresent()) {
			throw new ReaderNotFoundException("Reader with Id :"  + id + " doesn't exist");
		}
		else {
			readerRepo.deleteById(id);
			return id;
		}
		

	}
	/*
	 * View Readers list
	 */

	@Override
	public List<Reader> viewReadersList() {
		List<Reader> result = new ArrayList<Reader>();
		readerRepo.findAll().forEach(Reader1 -> result.add(Reader1));
		
		return result;
	}
	/*
	 * View reader details by Id
	 */

	@Override
	public Reader viewReaderById(int id) throws ReaderNotFoundException {
		Optional<Reader> reader = readerRepo.findById(id);
		if(reader.isPresent()) {
			return reader.get();
		}
		else {
		throw new ReaderNotFoundException("Reader with ID :" + id + " doesn't exist");
	}
	}

	/*
	 * Login Validate
	 */

	@Override
	public Reader loginValidate(String readerId, String password) throws ReaderNotFoundException {
		int i = Integer.parseInt(readerId);
		if(i == (new Reader().getId()) && password.equals(new Reader().getPassword())) {
				return readerRepo.save(new Reader());
			}
		
	    else {
			throw new ReaderNotFoundException("The entered id or password is wrong");
		}
		
}
	/*
	 * Validate Reader details
	 */
	private boolean validateReader(final Reader reader) throws ValidateReaderException{
		if (!reader.getPassword().matches(ReaderConstants.PASSWORD_PATTERN)) {
			throw new ValidateReaderException(ReaderConstants.PASSWORD_INVALID);
		}
		if (!reader.getFirstName().matches(ReaderConstants.NAME_PATTERN)) {
			throw new ValidateReaderException(ReaderConstants.NAME_CANNOT_BE_EMPTY1);
		}
		if (!reader.getLastName().matches(ReaderConstants.NAME_PATTERN)) {
			throw new ValidateReaderException(ReaderConstants.NAME_CANNOT_BE_EMPTY2);
		}
		if (!reader.getMobileno().matches(ReaderConstants.PHONENUMBER_PATTERN)) {
			throw new ValidateReaderException(ReaderConstants.MOBILE_NUMBER_CANNNOT_BE_EMPTY);
		}
		if (!reader.getEmail().matches(ReaderConstants.EMAIL_PATTERN)) {
			throw new ValidateReaderException(ReaderConstants.EMAIL_CANNOT_BE_EMPTY);
		}
		
		return true;
		
	}
	
	
	
	
	
	
}