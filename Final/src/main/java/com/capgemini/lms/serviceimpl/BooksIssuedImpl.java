package com.capgemini.lms.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.lms.constants.BooksIssuedConstants;
import com.capgemini.lms.entities.BooksIssued;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.ValidateIssueException;
import com.capgemini.lms.repository.BooksIssuedRepository;
import com.capgemini.lms.service.BooksIssuedService;
@Service
public class BooksIssuedImpl implements BooksIssuedService {
	@Autowired
	BooksIssuedRepository booksIssuedRepository;
	/*
	 * Add BooksIssued
	 */

	@Override
	public BooksIssued addIssuedBook(BooksIssued issued) throws ValidateIssueException {
		validateBooksissued(issued);
		return booksIssuedRepository.save(issued);
		
	}
	/*
	 * Update BooksIssued
	 */

	@Override
	public BooksIssued updateIssuedBookDetails(BooksIssued booksIssued) throws BookNotFoundException,ValidateIssueException {
		Optional<BooksIssued> issue = booksIssuedRepository.findById(booksIssued.getIssueId());
		if(issue.isPresent() && validateBooksissued(booksIssued) == true) {
			return booksIssuedRepository.save(booksIssued);	
		}
		else {
			throw new BookNotFoundException("Issue with ID :" + booksIssued.getIssueId() + "doesn't exist");
		}		
     }  
		
		
	/*
	 * Remove BooksIssued
	 */

	
	public int deleteIssuedBookS(int bookid) throws BookNotFoundException {
			Optional<BooksIssued> issue = booksIssuedRepository.findById(bookid);
			if(!issue.isPresent()) {
				throw new BookNotFoundException("The removed issue id cannot be null");
			}
			else {
				booksIssuedRepository.deleteById(bookid);
				return bookid;
			}
		}
		//try {
			//booksIssuedRepository.deleteById(bookid);
		//} catch (Exception e) {
			//throw new BookNotFoundException("The object cannot be null");
		//}
		
	@Override
	public List<BooksIssued> viewBooksIssuedList() {
		 List<BooksIssued> result = new ArrayList<BooksIssued>();
	        booksIssuedRepository.findAll().forEach(booksissued1 -> result.add(booksissued1));
	        return result;
		
	}
	public boolean validateBooksissued(BooksIssued issued ) throws ValidateIssueException {
		
		if (!issued.getQuantity(). matches (BooksIssuedConstants.QUANTITY_PATTERN)) {
			throw new ValidateIssueException(BooksIssuedConstants.QUANTITY_CANNOT_BE_EMPTY);
		
		}
		
		

		if (!issued.getIssueDate().matches ("\\d{4}-\\d{2}-\\d{2}" )) {
			throw new ValidateIssueException(BooksIssuedConstants.ISSUE_DATE_CANNOT_BE_EMPTY);
		}
		
		if (!issued.getDueDate().matches( "\\d{4}-\\d{2}-\\d{2}" )) {
			throw new ValidateIssueException(BooksIssuedConstants.DUE_DATE_CANNOT_BE_EMPTY);
		}
		return true;
		
		
}
}

		
		
	



		


	
	


