package com.capgemini;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import java.time.LocalDate;
import java.util.List;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.Reader;
import com.capgemini.lms.entities.SuggestedBooks;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.UserNotFoundException;
import com.capgemini.lms.exception.ValidateSuggestedBooksException;
import com.capgemini.lms.exception.ValidateUserException;
import com.capgemini.lms.service.ReaderService;
import com.capgemini.lms.service.SuggestedBooksService;
import com.capgemini.lms.serviceimpl.Usersimpl;


public class SuggestedBooksTest extends FinalApplicationTests {
	
	@Autowired
	SuggestedBooksService sb;
	@Autowired
	Usersimpl ui;
	
	@Test
	public void testaddSuggestedBookStatus() throws BookNotFoundException, ValidateSuggestedBooksException, UserNotFoundException, ValidateUserException{
		Users users = new Users(18,"abc@123","Durgam","Neelima","9989151461","neelima@gmail.com","1996-5-25","2020-5-5","2020-8-5","Active");
		users= ui.register(users);
		SuggestedBooks suggestedBooks = new SuggestedBooks(41,users,"C program", "Programming", "David", "Surya publications","Book on c", "2000-05-05","yes");
		suggestedBooks = sb.addSuggestedBook(suggestedBooks);
		assertNotNull(suggestedBooks);
	}
		
	@Test
	public void testupdateSuggestedBookStatus() throws BookNotFoundException, ValidateSuggestedBooksException, UserNotFoundException, ValidateUserException{
		Users users = new Users(18,"abc@123","Durgam","Neelima","9989151461","neelima@gmail.com","1996-5-25","2020-5-5","2020-8-5","Active");
		users= ui.register(users);
		SuggestedBooks suggestedBooks = new SuggestedBooks(31,users,"C program", "Programming", "David", "Surya publications","Book on c","2000-05-05","yes");
		suggestedBooks = sb.updateSuggestedBookStatus(suggestedBooks);
		assertNotNull(suggestedBooks);
	}
	
	@Test
	public void testdeleteSuggestedBooks() throws BookNotFoundException{
		int id = sb.deleteSuggestedBooks(25);
		assertEquals(id, 25);
	}
	
	@Test
	public void testviewSuggestedBookDetails() throws BookNotFoundException, ValidateSuggestedBooksException, UserNotFoundException, ValidateUserException{
		Users users = new Users(19,"abc@123","P","Supraja","97898765","supraja@gmail.com","1996-5-25","2020-5-5","2020-8-5","Active");
		users= ui.register(users);
		SuggestedBooks suggestedBooks = new SuggestedBooks(41,users,"C program", "Programming", "David", "Surya publications","Book on c", "2000-05-05","yes");
		suggestedBooks = sb.addSuggestedBook(suggestedBooks);
		assertEquals(suggestedBooks.getId(),41);
		
		}

	
	@Test 
	public void testviewSuggestedBooksList() throws BookNotFoundException{
		List<SuggestedBooks> suggestedBooks = sb.viewSuggestedBooksList();
		assertThat(suggestedBooks).size().isGreaterThan(0);
			
	}
	
}
