package com.capgemini.lms.service;
import java.util.List;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.SuggestedBooks;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.ValidateSuggestedBooksException;


public interface SuggestedBooksService {
	
	public SuggestedBooks updateSuggestedBookStatus(SuggestedBooks book) throws BookNotFoundException, ValidateSuggestedBooksException;
	public int deleteSuggestedBooks(int id) throws BookNotFoundException;
	public SuggestedBooks viewSuggestedBookDetails(int id) throws BookNotFoundException;
	public List<SuggestedBooks> viewSuggestedBooksList();
	public SuggestedBooks addSuggestedBook(SuggestedBooks book) throws ValidateSuggestedBooksException;
	

}
