package com.capgemini.lms.controller;
import com.capgemini.lms.serviceimpl.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.lms.constants.*;
import com.capgemini.lms.entities.*;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.ValidateBooksReturnedException;

@RestController
public class BooksReturnedController {
	@Autowired
	BooksReturnedServiceImp bs;
	public  BooksReturnedController(BooksReturnedServiceImp bookreturnimpl) {
		this.bs = bookreturnimpl;
	}
@GetMapping(value="/getBooksReturned",produces=MediaType.APPLICATION_JSON_VALUE)
private List<BooksReturned> viewReturnedBooksList(){
	return bs.viewReturnedBooksList();
}
@GetMapping("/getBooksReturned/{id}")
private List<BooksReturned> viewReturnedBooksList(@PathVariable("id") int Id){
	return bs.viewReturnedBooksList();}

@PostMapping("/postBooksReturned")
private SuccessMessage addReturnBooks(@RequestBody BooksReturned booksreturned) throws ValidateBooksReturnedException{
	bs.addReturnBooks(booksreturned);
	return new SuccessMessage(BooksReturnedConstants.BOOKS_ADDED+ booksreturned.getId());
}
@GetMapping(value="/delayedBookslist",produces=MediaType.APPLICATION_JSON_VALUE)
private List<BooksReturned> viewDelayedBooksList(){
	return bs.viewDelayedBooksList();
}
@PutMapping("/updateBooksReturned")
private SuccessMessage update(@RequestBody BooksReturned booksreturned) throws BookNotFoundException, ValidateBooksReturnedException {
	bs.updateReturnedBookDetails(booksreturned);
	return new SuccessMessage(BooksReturnedConstants.BOOKS_UPDATED+ booksreturned.getId());
}
}
