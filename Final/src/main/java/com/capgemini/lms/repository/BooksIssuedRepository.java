package com.capgemini.lms.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.capgemini.lms.entities.BooksIssued;

public interface BooksIssuedRepository extends CrudRepository<BooksIssued, Integer> {
	    
	}


