package com.capgemini.lms.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.constants.FeedbackConstants;
import com.capgemini.lms.entities.Feedback;
import com.capgemini.lms.exception.FeedbackNotFoundException;
import com.capgemini.lms.exception.ValidateFeedbackException;
import com.capgemini.lms.repository.FeedbackRepository;
import com.capgemini.lms.service.FeedbackService;

@Service
public class FeedService implements FeedbackService {
	@Autowired
	FeedbackRepository feedbackRepository;
	
	/*
	 * Write Feedback Details
	 */
	@Override
	public Feedback writeFeedback(Feedback feedback) throws FeedbackNotFoundException, ValidateFeedbackException {
		validateFeedback(feedback);
		return feedbackRepository.save(feedback);
	}

	/*
	 * Update Feedback Details
	 */
	@Override
	public Feedback updateFeedback(Feedback feedback) throws FeedbackNotFoundException, ValidateFeedbackException {
		Optional<Feedback> fb = feedbackRepository.findById(feedback.getId());
		if(fb.isPresent() && validateFeedback(feedback)) {
			return feedbackRepository.save(feedback);
		} else {
			throw new FeedbackNotFoundException("Feedback with ID: " + feedback.getId() + " does not exist");
		}
	}

	/*
	 * View Feedback List
	 */
	@Override
	public List<Feedback> viewFeedbackList() {
		// TODO Auto-generated method stub
		List<Feedback> result = new ArrayList<Feedback>();
		feedbackRepository.findAll().forEach(feedback1 -> result.add(feedback1));
		
		return result;
	}

	/*@Override
	public Users viewFeedBackByUser(int userid) throws FeedbackNotFoundException {
		// TODO Auto-generated method stub
		try {
			return usersRepository.findById(userid).get();
		} catch (Exception e) {
			throw new FeedbackNotFoundException("the passed object cannot be null");
		}
		//return null;
	}*/
	
	/*
	 * Validate Feedback Details
	 */
	public boolean validateFeedback(Feedback feedback) throws ValidateFeedbackException {
		if(!feedback.getFeedbackDate().matches(FeedbackConstants.DATE_PATTERN)) {
			throw new ValidateFeedbackException(FeedbackConstants.INVALID_DATE);
		}
		if(!feedback.getDescription().matches(FeedbackConstants.ALPHA_ONLY_PATTERN)) {
			throw new ValidateFeedbackException(FeedbackConstants.EMPTY_DESCRIPTION);
		}
		if(!feedback.getRating().matches("[1-5]")) {
			throw new ValidateFeedbackException(FeedbackConstants.INVALID_RATING);
		}
		if(!feedback.getComments().matches(FeedbackConstants.ALPHA_ONLY_PATTERN)) {
			throw new ValidateFeedbackException(FeedbackConstants.EMPTY_COMMENTS);
		}
		return true;
	}


}
