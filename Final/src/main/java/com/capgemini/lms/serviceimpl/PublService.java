package com.capgemini.lms.serviceimpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.constants.PublishersConstants;
import com.capgemini.lms.entities.Publishers;
import com.capgemini.lms.exception.PublisherNotFoundException;
import com.capgemini.lms.exception.ValidatePublisherException;
import com.capgemini.lms.repository.PublishersRepository;
import com.capgemini.lms.service.PublisherService;

@Service
public class PublService implements PublisherService {
	
	@Autowired
	PublishersRepository publishersRepository;

	/*
	 * Add Publisher Details
	 */
	@Override
	public Publishers addPublisher(Publishers publisher) throws PublisherNotFoundException, ValidatePublisherException {
		validatePublisher(publisher);
		return publishersRepository.save(publisher);
	}

	/*
	 * Update Publisher Details
	 */
	@Override
	public Publishers updatePublisherDetails(Publishers publisher) throws PublisherNotFoundException, ValidatePublisherException {
		Optional<Publishers> pub = publishersRepository.findById(publisher.getPublisherId());
		if(pub.isPresent() && validatePublisher(publisher)) {
			return publishersRepository.save(publisher);
		} else {
			throw new PublisherNotFoundException("Publisher with ID: " + publisher.getPublisherId() + " does not exist");
		}
	}

	/*
	 * Remove Publisher Details
	 */
	@Override
	public int removePublisher(int publisherId) throws PublisherNotFoundException {
		Optional<Publishers> pub = publishersRepository.findById(publisherId);
		if(!pub.isPresent()) {
			throw new PublisherNotFoundException("Publisher with given ID not present");
		} else {
			publishersRepository.deleteById(publisherId);
			return publisherId;
		}
	}

	/*
	 * View All Publishers Details
	 */
	@Override
	public List<Publishers> viewPublishersList() {
		// TODO Auto-generated method stub
		List<Publishers> result = new ArrayList<Publishers>();
		publishersRepository.findAll().forEach(publisher1 -> result.add(publisher1));
		return result;
	}

	/*
	 * View Publishers by ID
	 */
	@Override
	public Publishers viewPublisherById(int id) throws PublisherNotFoundException {
		Optional<Publishers> pub = publishersRepository.findById(id);
		if(pub.isPresent()) {
			return publishersRepository.findById(id).get();
		} else {
			throw new PublisherNotFoundException("Publisher with given ID not present");
		}
		//return null;
	}
	
	/*
	 * Validate Publisher Details
	 */
	public boolean validatePublisher(Publishers publisher) throws  ValidatePublisherException{
		if(!publisher.getAddress1().matches(PublishersConstants.ADDRESS_PATTERN)) {
			throw new ValidatePublisherException(PublishersConstants.ADDRESS_CANNOT_BE_EMPTY);
		}
		if(!publisher.getAddress2().matches(PublishersConstants.ADDRESS_PATTERN)) {
			throw new ValidatePublisherException(PublishersConstants.ADDRESS_CANNOT_BE_EMPTY);
		}
		if (!publisher.getCity().matches(PublishersConstants.ALPHA_ONLY_PATTERN)) {
			throw new ValidatePublisherException(PublishersConstants.CITY_CANNOT_BE_EMPTY);
		}
		if (!publisher.getState().matches(PublishersConstants.ALPHA_ONLY_PATTERN)) {
			throw new ValidatePublisherException(PublishersConstants.STATE_CANNOT_BE_EMPTY);
		}
		if (!publisher.getPincode().matches("[1-9][0-9]{5}")) {
			throw new ValidatePublisherException(PublishersConstants.PINCODE_CANNOT_BE_EMPTY);
		}
		if (!publisher.getPublisherName().matches(PublishersConstants.ALPHA_ONLY_PATTERN)) {
			throw new ValidatePublisherException(PublishersConstants.NAME_CANNOT_BE_EMPTY);
		}
		if (!publisher.getEmail().matches(PublishersConstants.EMAIL_PATTERN)) {
			throw new ValidatePublisherException(PublishersConstants.EMAIL_CANNOT_BE_EMPTY);
		}
		if (!publisher.getContactno().matches("[1-9][0-9]{9}")) {
			throw new ValidatePublisherException(PublishersConstants.CONTACT_CANNOT_BE_EMPTY);
		}
		return true;
	}

}
