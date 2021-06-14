package com.capgemini.lms.serviceimpl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.constants.ReaderConstants;
import com.capgemini.lms.constants.SuggestedBooksConstants;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.Reader;
import com.capgemini.lms.entities.SuggestedBooks;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.ReaderNotFoundException;
import com.capgemini.lms.exception.ValidateReaderException;
import com.capgemini.lms.exception.ValidateSuggestedBooksException;
import com.capgemini.lms.service.SuggestedBooksService;

import com.capgemini.lms.repository.SuggestedBooksRepository;

@Service
public class SuggestedBooksServiceImpl implements SuggestedBooksService {
	
	@Autowired
	SuggestedBooksRepository suggestedBooksRepo;
    
	/*
	 * Updating the suggested_books
	 */

	@Override
	public SuggestedBooks updateSuggestedBookStatus(SuggestedBooks book) throws BookNotFoundException, ValidateSuggestedBooksException {
		Optional<SuggestedBooks> suggestedBooks = suggestedBooksRepo.findById(book.getId());
		if(suggestedBooks.isPresent() && validateSuggestedBooks(book) == true) {
			return suggestedBooksRepo.save(book);
		}
		else {
			throw new BookNotFoundException("Book  with ID :"+ book.getId() + "doesn't exists");
			  
		}
	
		
	}
    
	/*
	 * Deleting suggested_books
	 */
	@Override
	public int deleteSuggestedBooks(int id) throws BookNotFoundException {
		Optional<SuggestedBooks> suggestedBooks = suggestedBooksRepo.findById(id);
		if(!suggestedBooks.isPresent()) {
			throw new BookNotFoundException("Book with Id :" + id + "doesn't exists ");
			
		}
		else {
		
			suggestedBooksRepo.deleteById(id);
			
	}
		return id;
	}

	/*
	 * View Suggested_books by Id
	 */
	@Override
	public SuggestedBooks viewSuggestedBookDetails(int id) throws BookNotFoundException {
		Optional<SuggestedBooks> suggestedBooks = suggestedBooksRepo.findById(id);
	
		if(suggestedBooks.isPresent()) {
			return suggestedBooks.get();
		}
		else {
			throw new BookNotFoundException("Reader with Id :" + id + "doesn't exists");
		}
	
	}
    /*
     * View suggested_books List
     */
	@Override
	public List<SuggestedBooks> viewSuggestedBooksList() {
		List<SuggestedBooks> result = new ArrayList<SuggestedBooks>();
		suggestedBooksRepo.findAll().forEach(SuggestedBooks1 -> result.add(SuggestedBooks1));
		return result;
	}
    
	/*
	 * Adding suggested_books
	 */
	@Override
	public SuggestedBooks addSuggestedBook(SuggestedBooks book) throws ValidateSuggestedBooksException {
		if (validateSuggestedBooks(book) == true) {
		suggestedBooksRepo.save(book);
		}
		else {
			throw new ValidateSuggestedBooksException("Please input data properly");
		}
	return book;
	}
    
	/*
	 * Validating the data
	 */
	
	private boolean validateSuggestedBooks(final SuggestedBooks suggestedBooks) throws ValidateSuggestedBooksException{
		if (!suggestedBooks.getTitle().matches(SuggestedBooksConstants.PATTERN)) {
			throw new ValidateSuggestedBooksException(SuggestedBooksConstants.TITLE_CANNOT_BE_EMPTY);
		}
		if (!suggestedBooks.getSubject().matches(SuggestedBooksConstants.PATTERN)) {
			throw new ValidateSuggestedBooksException(SuggestedBooksConstants.SUBJECT_CANNOT_BE_EMPTY);
		}
		if (!suggestedBooks.getAuthor().matches(SuggestedBooksConstants.PATTERN)) {
			throw new ValidateSuggestedBooksException(SuggestedBooksConstants.AUTHOR_CANNOT_BE_EMPTY);
		}
		if (!suggestedBooks.getPublications().matches(SuggestedBooksConstants.PATTERN)) {
			throw new ValidateSuggestedBooksException(SuggestedBooksConstants.PUBLICATIONS_CANNOT_BE_EMPTY);
		}
		if (!suggestedBooks.getSuggested_date().matches(SuggestedBooksConstants.DATE_PATTERN)) {
			throw new ValidateSuggestedBooksException(SuggestedBooksConstants.DATE_INVALID);
		}
		
	
		if (!suggestedBooks.getStatus().matches(SuggestedBooksConstants.PATTERN)) {
			throw new ValidateSuggestedBooksException(SuggestedBooksConstants.STATUS_CANNOT_BE_EMPTY);
		}
		
		
		return true;
		
	}
	
	
	
	

}
