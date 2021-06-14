package com.capgemini.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lms.constants.FeedbackConstants;
import com.capgemini.lms.constants.SuccessMessage;
import com.capgemini.lms.entities.Feedback;
import com.capgemini.lms.exception.FeedbackNotFoundException;
import com.capgemini.lms.exception.ValidateFeedbackException;
import com.capgemini.lms.serviceimpl.FeedService;

@RestController
public class FeedbackController {
	
	@Autowired
	FeedService fs;
	
	@GetMapping(value = "/feedbacks")
	private List<Feedback> viewFeedbackList() {
		return fs.viewFeedbackList();
	}
	
	/*@GetMapping("getfeedback/{userid}")
	private Users viewFeedbackList(@PathVariable("userid") int userid) throws FeedbackNotFoundException {
		return fs.viewFeedBackByUser(userid);
	}*/
	
	@PostMapping("/savefeedback")
	private SuccessMessage saveFeedback(@RequestBody Feedback feedback) throws FeedbackNotFoundException, ValidateFeedbackException {
		fs.writeFeedback(feedback);
		return new SuccessMessage(FeedbackConstants.FEEDBACK_ADDED + feedback.getId());
	}
	
	@PutMapping("/updatefeedback")
	private SuccessMessage update(@RequestBody Feedback feedback) throws FeedbackNotFoundException, ValidateFeedbackException {
		fs.updateFeedback(feedback);
		return new SuccessMessage(FeedbackConstants.FEEDBACK_UPDATED + feedback.getId());
	}

}
