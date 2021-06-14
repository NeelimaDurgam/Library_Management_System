package com.capgemini.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.lms.entities.BooksIssued;
import com.capgemini.lms.exception.AddressNotFoundException;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.ValidateIssueException;

public interface BooksIssuedService {
	public BooksIssued addIssuedBook(BooksIssued issued)throws ValidateIssueException, BookNotFoundException;
	public BooksIssued updateIssuedBookDetails(BooksIssued booksIssued)throws ValidateIssueException, BookNotFoundException;;
	public int deleteIssuedBookS(int bookid) throws BookNotFoundException;
	public List<BooksIssued> viewBooksIssuedList();
}

