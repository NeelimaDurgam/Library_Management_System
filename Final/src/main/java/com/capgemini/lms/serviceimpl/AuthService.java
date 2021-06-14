package com.capgemini.lms.serviceimpl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.lms.constants.AuthorConstants;
import com.capgemini.lms.entities.Author;
import com.capgemini.lms.service.AuthorService;
import com.capgemini.lms.exception.AuthorNotFoundException;
import com.capgemini.lms.exception.ValidateAuthorException;
import com.capgemini.lms.repository.AuthorRepository;

@Service
public class AuthService implements AuthorService{
	@Autowired
	AuthorRepository authorRepository;
	
	/*
	 * Add author details
	 */
	public Author addAuthorDetails(Author author) throws AuthorNotFoundException, ValidateAuthorException{
	
		validateAuthorDetails(author);
		authorRepository.save(author);
		    return author;			
	}
	/*
	 * Update author details
	 */
	public Author updateAuthorDetails(Author author) throws AuthorNotFoundException, ValidateAuthorException {
			Optional<Author> authors = authorRepository.findById(author.getAuthorId());
			if(authors.isPresent() && validateAuthorDetails(author) == true) {
				return authorRepository.save(author);	
			}
			else {
				throw new AuthorNotFoundException("Author with ID :" + author.getAuthorId() + "doesn't exist");
			}		
	}
	/*
	 * Delete author details
	 */
	public int deleteAuthorDetails(int authorId) throws AuthorNotFoundException {
		Optional<Author> author = authorRepository.findById(authorId);
		if(!author.isPresent()) {
			throw new AuthorNotFoundException("The deleted object cannot be null");
		}
		else {
			authorRepository.deleteById(authorId);
			return authorId;
		}
	}
	/*
	 * View authors list or authors list
	 */
	public List<Author> viewAuthorsList() {
		 List<Author> result = new ArrayList<Author>();
		 authorRepository.findAll().forEach(author1 -> result.add(author1));
		 return result;
	}
	/*
	 * View author by id
	 */
	
	public Author viewAuthorById(int id) throws AuthorNotFoundException {
		try {
			if(id!=0)
			return authorRepository.findById(id).get();
		}catch(Exception e) {
			throw new AuthorNotFoundException("The object cannot be null");
		}
		return null;
	}
	/*
	 * Validations for author entity
	 */
	public boolean validateAuthorDetails(Author author ) throws ValidateAuthorException {
		if (!author.getFirstName().matches(("[a-zA-Z]+|[A-Za-z]+[ ]{1}[a-zA-Z]+"))) {
			throw new ValidateAuthorException(AuthorConstants.FIRSTNAME_CANNOT_BE_EMPTY);
		}
		if (!author.getLastName().matches(("[a-zA-Z]+|[A-Za-z]+[ ]{1}[a-zA-Z]+"))) {
			throw new ValidateAuthorException(AuthorConstants.LASTNAME_CANNOT_BE_EMPTY);
		}
		if (!author.getEmail().matches("[A-Za-z0-9+_.-]+@(.+)$")) {
			throw new ValidateAuthorException(AuthorConstants.EMAIL_CANNOT_BE_EMPTY);
		}
		if (!author.getContactno().matches("^[6-9][0-9]{9}")) {
			throw new ValidateAuthorException(AuthorConstants.CONTACT_NUMBER_CANNOT_BE_EMPTY);
		}
		return true;
	}
	

}
