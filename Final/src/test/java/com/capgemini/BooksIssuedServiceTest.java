package com.capgemini;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksIssued;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.UserNotFoundException;
import com.capgemini.lms.exception.ValidateIssueException;
import com.capgemini.lms.exception.ValidateUserException;
import com.capgemini.lms.service.BooksIssuedService;
import com.capgemini.lms.serviceimpl.BooksIssuedImpl;
import com.capgemini.lms.serviceimpl.Booksimpl;
import com.capgemini.lms.serviceimpl.Usersimpl;
import com.fasterxml.jackson.annotation.JsonFormat;

public class BooksIssuedServiceTest extends FinalApplicationTests {
	@Autowired
	BooksIssuedImpl as;
	@Autowired
	Usersimpl ui;
	Books books;
	@Autowired
	Booksimpl os;
	@Test
	public void testDeleteIssuedBookS() throws BookNotFoundException{
		int id = as.deleteIssuedBookS(21);
		assertEquals(id, 21);
	}
	@Test
	public void testviewBooksIssuedList() {
		List<BooksIssued> bp = as.viewBooksIssuedList();
		assertThat(bp).size().isGreaterThan(0);
	}
	
	@Test
	public void testaddIssuedBook() throws BookNotFoundException, ValidateIssueException, UserNotFoundException, ValidateUserException {
		Users user = new Users(9,"abc@123","P","Supraja","97898765","supraja@gmail.com", "1996-05-25", "2020-05-05","2020-08-05","Active");
		user= ui.register(user);
		List<Books> booksissued = new ArrayList<Books>();
		 books = new Books(27,"FourthRow","java", "prat", 2010, "678", 3, 5555.0, "third row","python");
		 //os.addBook(books);
		booksissued.add(books);
		BooksIssued bp = new BooksIssued(10, user, booksissued, "2021-05-22",  "5", "2021-06-13");
		bp = as.addIssuedBook(bp);
		assertNotNull(bp);
	}
	@Test 
	public void testupdateIssuedBookDetails() throws BookNotFoundException, ValidateIssueException, UserNotFoundException, ValidateUserException {
		Users user = new Users(9,"abc@123","P","Supraja","97898765","supraja@gmail.com", "1996-05-25", "2020-05-05", "2020-08-05","Active");
		user= ui.register(user);
		List<Books> booksissued = new ArrayList<Books>();
		 books = new Books(27,"FourthRow","java", "prat", 2010, "678", 3, 5555.0, "third row","python");
		booksissued.add(books);
		BooksIssued bp = new BooksIssued(19, user, booksissued, "2021-04-04", "5", "2022-04-02");
		bp = as.updateIssuedBookDetails(bp);
		assertNotNull(bp); 
	}
}
