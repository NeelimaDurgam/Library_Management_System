package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.entities.BooksReturned;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.ValidateBooksReturnedException;

public interface BooksReturnedService {
	public BooksReturned addReturnBooks(BooksReturned returned) throws ValidateBooksReturnedException;
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned) throws BookNotFoundException, ValidateBooksReturnedException;
	public List<BooksReturned> viewReturnedBooksList();
	public List<BooksReturned> viewDelayedBooksList();
}
