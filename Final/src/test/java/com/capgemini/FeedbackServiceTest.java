package com.capgemini;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.lms.entities.Feedback;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.FeedbackNotFoundException;
import com.capgemini.lms.exception.UserNotFoundException;
import com.capgemini.lms.exception.ValidateFeedbackException;
import com.capgemini.lms.exception.ValidateUserException;
import com.capgemini.lms.serviceimpl.FeedService;
import com.capgemini.lms.serviceimpl.Usersimpl;

public class FeedbackServiceTest extends FinalApplicationTests{
	@Autowired
	FeedService fs;
	@Autowired
	Usersimpl ul;
	
	@Test
	public void testWriteFeedback() throws FeedbackNotFoundException, UserNotFoundException, ValidateFeedbackException, ValidateUserException {
		Users user = new Users(4, "abc@123", "V", "SK", "7897897899", "vsk@gmail.com", "1999-07-07", "2020-10-10", "2021-10-10", "yes");
		user = ul.register(user);
		Feedback np = new Feedback(6, user, "1999-09-09", "VeryGood", "3", "VeryGood");
		np = fs.writeFeedback(np);
		assertNotNull(np);
		assertEquals(np.getFeedbackDate(), "1999-09-09");
		assertEquals(np.getId(), 6);
		assertEquals(np.getDescription(), "VeryGood");
		assertEquals(np.getRating(), "3");
		assertEquals(np.getComments(), "VeryGood");
		
	}
	
	@Test
	public void testViewFeedbackList() throws FeedbackNotFoundException {
		List<Feedback> fb = fs.viewFeedbackList();
		assertThat(fb).size().isGreaterThan(0);
	}
	
	@Test
	public void testUpdateFeedback() throws FeedbackNotFoundException, UserNotFoundException, ValidateFeedbackException, ValidateUserException {
		Users user = new Users(4, "abc@123", "V", "SK", "7897897899", "vsk@gmail.com", "1999-07-07", "2020-10-10", "2021-10-10", "yes");
		user = ul.register(user);
		Feedback np = new Feedback(6, user, "1999-09-09", "VeryGood", "3", "VeryGood");
		np = fs.updateFeedback(np);
		assertNotNull(np);
		assertEquals(np.getFeedbackDate(), "1999-09-09");
		assertEquals(np.getId(), 6);
		assertEquals(np.getDescription(), "VeryGood");
		assertEquals(np.getRating(), "3");
		assertEquals(np.getComments(), "VeryGood");
	}
	
	/*@Test
	public void testViewFeedBackByUser() throws FeedbackNotFoundException {
		Users user = new Users(1, "abc@123", "V", "SK", "7897897899", "vsk@gmail.com", LocalDate.of(1999, 7, 7), LocalDate.of(2020, 10, 10), LocalDate.of(2020, 10, 10), "yes");
		user = ul.register(user);
		Feedback fb = new Feedback(1, user, "10-10-2021", "Good", "4", "Hello");
		Feedback np = fs.writeFeedback(fb);
		assertNotNull(np);
		assertEquals(np.getFeedbackDate(), "10-10-2021");
		assertEquals(np.getId(), 1);
		assertEquals(np.getDescription(), "Good");
		assertEquals(np.getRating(), "4");
		assertEquals(np.getComments(), "Hello");
	}*/
	
	

}
