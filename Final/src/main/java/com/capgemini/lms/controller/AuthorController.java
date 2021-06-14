package com.capgemini.lms.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lms.constants.AuthorConstants;
import com.capgemini.lms.constants.SuccessMessage;
import com.capgemini.lms.entities.Author;
import com.capgemini.lms.exception.AuthorNotFoundException;
import com.capgemini.lms.exception.ValidateAuthorException;
import com.capgemini.lms.serviceimpl.AuthService;


@RestController
public class AuthorController{
	@Autowired
	AuthService as;

	@GetMapping("/getAuthor")
	private List<Author> viewAuthorsList(){
		return as.viewAuthorsList();
	}
	
	@DeleteMapping("/deleteAuthor/{authorId}")
	private SuccessMessage deleteAuthorDetails(@PathVariable("authorId") int authorId) throws AuthorNotFoundException{
		 as.deleteAuthorDetails(authorId);
		 return new SuccessMessage(AuthorConstants.AUTHOR_REMOVED);
	}
	
	@GetMapping("/getAuthor/{id}")
	private Author viewAuthorById(@PathVariable("id") int id) throws AuthorNotFoundException {
		 return as.viewAuthorById(id);
	}
	
	@PostMapping("/postAuthor")
	private  SuccessMessage saveAuthor(@RequestBody Author author) throws AuthorNotFoundException, ValidateAuthorException {
		as.addAuthorDetails(author);
		return new SuccessMessage(AuthorConstants.AUTHOR_ADDED + author.getAuthorId());
	}
	
	@PutMapping("/updateAuthorDetails")
	private  SuccessMessage update(@RequestBody Author author) throws AuthorNotFoundException, ValidateAuthorException {
		as.updateAuthorDetails(author);
		return new SuccessMessage(AuthorConstants.AUTHOR_UPDATED+ author.getAuthorId());
	}
	
}