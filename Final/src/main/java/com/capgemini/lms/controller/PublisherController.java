package com.capgemini.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lms.constants.PublishersConstants;
import com.capgemini.lms.constants.SuccessMessage;
import com.capgemini.lms.entities.Publishers;
import com.capgemini.lms.exception.PublisherNotFoundException;
import com.capgemini.lms.exception.ValidatePublisherException;
import com.capgemini.lms.serviceimpl.PublService;

@RestController
public class PublisherController {
	
	@Autowired
	PublService ps;
	
	@GetMapping(value = "/publishers")
	private List<Publishers> viewPublishersList() {
		return ps.viewPublishersList();
	}
	
	@GetMapping("getpublisher/{publisherId}")
	private Publishers viewPublishersList(@PathVariable("publisherId") int publisherId) throws PublisherNotFoundException {
		return ps.viewPublisherById(publisherId);
	}
	
	@DeleteMapping("/deletepublisher/{publisherId}")
	private SuccessMessage removePublisher(@PathVariable("publisherId") int id) throws PublisherNotFoundException {
		ps.removePublisher(id);
		return new SuccessMessage(PublishersConstants.PUBLISHER_DETAILS_DELETED+ id);

	}
	
	@PostMapping("/postpublisher")
	private SuccessMessage savePublisher(@RequestBody Publishers publisher) throws PublisherNotFoundException, ValidatePublisherException {
		ps.addPublisher(publisher);
		return new SuccessMessage(PublishersConstants.PUBLISHER_DETAILS_ADDED+ publisher.getPublisherId());
	}
	
	@PutMapping("/updatepublisher")
	private SuccessMessage update(@RequestBody Publishers publisher) throws PublisherNotFoundException, ValidatePublisherException {
		ps.updatePublisherDetails(publisher);
		return new SuccessMessage(PublishersConstants.PUBLISHER_DETAILS_UPDATED+ publisher.getPublisherId());
	}
	
	

}
