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

import com.capgemini.lms.constants.SuccessMessage;
import com.capgemini.lms.constants.SuggestedBooksConstants;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.Reader;
import com.capgemini.lms.entities.SuggestedBooks;

import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.ReaderNotFoundException;
import com.capgemini.lms.exception.ValidateSuggestedBooksException;
import com.capgemini.lms.service.ReaderService;
import com.capgemini.lms.service.SuggestedBooksService;
import com.capgemini.lms.serviceimpl.*;
@RestController
public class SuggestedBooksController {
	@Autowired
	SuggestedBooksService as;
	
	@GetMapping("/getSuggestedBooks")
	private List<SuggestedBooks> viewSuggestedBooksList(){
		return as.viewSuggestedBooksList();
	}
	@GetMapping("/getSuggestedBooksById/{id}")
	private SuggestedBooks viewSuggestedBooksList(@PathVariable("id") int id) throws BookNotFoundException{
		return as.viewSuggestedBookDetails(id);
	}
	@DeleteMapping("/deleteSuggestedBooks/{id}")
	private int deleteSuggestedBooks(@PathVariable("id") int id) throws BookNotFoundException{
		return as.deleteSuggestedBooks(id);
	}
	@PostMapping("/addSuggestedBooks")
	private SuccessMessage saveSuggestedBooks(@RequestBody SuggestedBooks suggestedbooks) throws BookNotFoundException, ValidateSuggestedBooksException {
		as.addSuggestedBook(suggestedbooks);
		return new SuccessMessage(SuggestedBooksConstants.BOOK_SUGGESTION_ADDED + suggestedbooks.getId());
	}
	@PutMapping("/updateSuggestedBooks")
	private SuccessMessage update(@RequestBody SuggestedBooks suggestedbooks) throws BookNotFoundException, ValidateSuggestedBooksException {
		as.updateSuggestedBookStatus(suggestedbooks);
		return new SuccessMessage(SuggestedBooksConstants.BOOK_UPDATED + suggestedbooks.getId());
	}
	
	
	

}
