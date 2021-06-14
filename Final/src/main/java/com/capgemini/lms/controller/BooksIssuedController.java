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

import com.capgemini.lms.constants.BooksIssuedConstants;
import com.capgemini.lms.constants.SuccessMessage;
import com.capgemini.lms.entities.BooksIssued;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.ValidateIssueException;
import com.capgemini.lms.serviceimpl.BooksIssuedImpl;
import com.capgemini.lms.serviceimpl.BooksIssuedImpl;


@RestController
public class BooksIssuedController {
@Autowired	
	BooksIssuedImpl bookimpl;
	public  BooksIssuedController(BooksIssuedImpl bookimpl) {
		this.bookimpl = bookimpl;
	}
		
		@GetMapping(value="/booksIssued")
		private List<BooksIssued> viewBooksIssuedList(){
			return bookimpl.viewBooksIssuedList();
		}
		@GetMapping("/booksIssued/{id}")
		private List<BooksIssued> viewBooksIssuedList(@PathVariable("id") int issueId){
			return bookimpl.viewBooksIssuedList();
		}
		@DeleteMapping("/booksIssued/{issueid}")
		private  SuccessMessage deleteBooksIssuedDetails(@PathVariable("issueid") int bookid) throws BookNotFoundException{
			bookimpl.deleteIssuedBookS(bookid);
			return new SuccessMessage(BooksIssuedConstants.BOOKS_ISSUED_REMOVED);
		}
		@PostMapping("/postBooksIssued")
		private SuccessMessage saveBooksIssued(@RequestBody BooksIssued issued) throws ValidateIssueException {
			bookimpl.addIssuedBook(issued);
			return new SuccessMessage(BooksIssuedConstants.BOOKS_ISSUED_ADDED+ issued.getIssueId());
			
		}
		@PutMapping("/updateBookIssue")
		private  SuccessMessage update(@RequestBody BooksIssued BooksIssued) throws ValidateIssueException, BookNotFoundException  {
			bookimpl.updateIssuedBookDetails(BooksIssued);
			return new SuccessMessage(BooksIssuedConstants.BOOKS_ISSUED_UPDATED);
			
		}
		
	}

