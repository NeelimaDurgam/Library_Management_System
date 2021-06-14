package com.capgemini.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.lms.entities.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer>{

}
