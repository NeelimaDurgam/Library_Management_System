package com.capgemini;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.capgemini.lms.entities.Publishers;
import com.capgemini.lms.exception.PublisherNotFoundException;
import com.capgemini.lms.exception.ValidatePublisherException;
import com.capgemini.lms.serviceimpl.PublService;

public class PublisherServiceTest extends FinalApplicationTests{
	@Autowired
	PublService ps;
	
	@Test
	public void testRemovePublisher() throws PublisherNotFoundException, ValidatePublisherException {
		Publishers np = new Publishers(8, "Satya", "8989889893", "sk@gmail.com", "block1", "road7", "Hyderabad", "Telangana", "500050");
		np = ps.addPublisher(np);
		assertNotNull(np);
		assertEquals(8, ps.removePublisher(np.getPublisherId()));
	}
	
	@Test
	public void viewPublishersList() {
		List<Publishers> pub = ps.viewPublishersList();
		assertThat(pub).size().isGreaterThan(0);
	}
	
	@Test
	public void testAddPublisher() throws PublisherNotFoundException, ValidatePublisherException {
		Publishers np = new Publishers(20, "Satya", "8989889893", "sk@gmail.com", "block1", "road7", "Hyderabad", "Telangana", "500050");
		np = ps.addPublisher(np);
		assertEquals(np.getPublisherId(), 20);
		assertEquals(np.getPublisherName(), "Satya");
		assertEquals(np.getContactno(), "8989889893");
		assertEquals(np.getEmail(), "sk@gmail.com");
		assertEquals(np.getAddress1(), "block1");
		assertEquals(np.getAddress2(), "road7");
		assertEquals(np.getCity(), "Hyderabad");
		assertEquals(np.getState(), "Telangana");
		assertEquals(np.getPincode(), "500050");
	}
	
	@Test
	public void testUpdatePublisherDetails() throws PublisherNotFoundException, ValidatePublisherException {
		Publishers np = new Publishers(20, "Satya", "8989889893", "sk@gmail.com", "block1", "road7", "Hyderabad", "Telangana", "500050");
		np = ps.updatePublisherDetails(np);
		assertEquals(np.getPublisherId(), 20);
		assertEquals(np.getPublisherName(), "Satya");
		assertEquals(np.getContactno(), "8989889893");
		assertEquals(np.getEmail(), "sk@gmail.com");
		assertEquals(np.getAddress1(), "block1");
		assertEquals(np.getAddress2(), "road7");
		assertEquals(np.getCity(), "Hyderabad");
		assertEquals(np.getState(), "Telangana");
		assertEquals(np.getPincode(), "500050");
	}
	
	@Test
	public void testViewPublisherById() throws PublisherNotFoundException {
		Publishers np = new Publishers(20, "Satya", "8989889893", "sk@gmail.com", "block1", "road7", "Hyderabad", "Telangana", "500050");
		assertEquals(np.getPublisherId(), 20);
	}

}
