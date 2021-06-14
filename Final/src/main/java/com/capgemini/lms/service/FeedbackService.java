package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.entities.Feedback;
import com.capgemini.lms.exception.FeedbackNotFoundException;
import com.capgemini.lms.exception.ValidateFeedbackException;

public interface FeedbackService {
	public Feedback writeFeedback(Feedback feedback) throws FeedbackNotFoundException, ValidateFeedbackException;
	public Feedback updateFeedback(Feedback feedback) throws FeedbackNotFoundException, ValidateFeedbackException;
	public List<Feedback> viewFeedbackList();
	//public Users viewFeedBackByUser(int userid) throws FeedbackNotFoundException;
}
