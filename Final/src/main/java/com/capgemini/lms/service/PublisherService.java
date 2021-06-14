package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.entities.Publishers;
import com.capgemini.lms.exception.PublisherNotFoundException;
import com.capgemini.lms.exception.ValidatePublisherException;

public interface PublisherService {
	public Publishers addPublisher(Publishers publisher) throws PublisherNotFoundException, ValidatePublisherException;
	public Publishers updatePublisherDetails(Publishers publisher) throws PublisherNotFoundException, ValidatePublisherException;
	public int removePublisher(int publisherId) throws PublisherNotFoundException;
	public List<Publishers> viewPublishersList();
	public Publishers viewPublisherById(int id) throws PublisherNotFoundException;
}
