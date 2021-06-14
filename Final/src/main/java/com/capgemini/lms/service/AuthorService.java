package com.capgemini.lms.service;

import java.util.List;


import com.capgemini.lms.entities.Author;
import com.capgemini.lms.exception.AuthorNotFoundException;
import com.capgemini.lms.exception.ValidateAuthorException;

public interface AuthorService {
	public Author addAuthorDetails(Author author) throws AuthorNotFoundException, ValidateAuthorException;
	public Author updateAuthorDetails(Author author) throws AuthorNotFoundException, ValidateAuthorException;
	public int deleteAuthorDetails(int authorId) throws AuthorNotFoundException;
	public List<Author> viewAuthorsList();
	public Author viewAuthorById(int id) throws AuthorNotFoundException;
}
