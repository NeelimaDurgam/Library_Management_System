package com.capgemini;
//import com.capgemini.lms.service.*;
import com.capgemini.lms.serviceimpl.*;
import com.capgemini.lms.exception.*;
import com.capgemini.lms.entities.*;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
public class BooksReturnedServiceImpTest extends FinalApplicationTests {
	@Autowired
	BooksReturnedServiceImp brs;
	@Autowired
	Usersimpl ul;
	Books books;
	@Test
	public void testaddreturnbooks() throws BookNotFoundException, ValidateBooksReturnedException, UserNotFoundException, ValidateUserException {
		books=new Books(1,"Programming in Java","Java","Tata Mc Graw",2010,"6789",3,500,"Fourth Row","BalaSubramanyam");
		List<Books> bookslist=new ArrayList<Books>();
		bookslist.add(books);
		Users user=new Users(1,"abc@123","P","Supraja","97898765","supraja@gmail.com","1996-05-25","2020-05-05","2020-08-05","Active");
		user=ul.register(user);
		BooksReturned br = new BooksReturned(1,user,bookslist,"2020-05-05","5","25","Accepted");
		br = brs.addReturnBooks(br);
		assertNotNull(br);
		assertEquals(br.getId(),1);
		assertEquals(br.getReturnedDate(),"2020-05-05");
		assertEquals(br.getDelayed_Days(),"5"); 
		assertEquals(br.getPenalty(),"25");
		assertEquals(br.getPenalty_Status(),"Accepted"); 
		
		
    }
	@Test
	public void testupdateReturnedBookDetails() throws BookNotFoundException, UserNotFoundException, ValidateBooksReturnedException, ValidateUserException {
		books=new Books(1,"Python","Python","Tata Mc Graw",2010,"6789",3,500,"Fourth Row","BalaSubramanyam");
		List<Books> bookslist=new ArrayList<Books>();
		bookslist.add(books);
		Users user=new Users(1,"123","P","Supraja","97898765","supraja@gmail.com","1996-05-25","2020-05-05","2020-08-05","Active");
		user=ul.updateUserDetails(user);
		BooksReturned br = new BooksReturned(1,user,bookslist,"2020-05-05","6","30","Accepted");
		br = brs.updateReturnedBookDetails(br);
		assertNotNull(br);
		assertEquals(br.getId(),1);
		assertEquals(br.getReturnedDate(),"2020-05-05");
		assertEquals(br.getDelayed_Days(),"6"); 
		assertEquals(br.getPenalty(),"30");
		assertEquals(br.getPenalty_Status(),"Accepted"); 
	}
	@Test
	public void testViewBooksReturnedList() {
		List<BooksReturned> lbr = brs.viewReturnedBooksList();
		assertThat(lbr).size().isGreaterThan(0);
	}
	@Test
	public void testViewDelayedBooksList() {
		List<BooksReturned> dbl = brs.viewDelayedBooksList();
		assertThat(dbl).size().isGreaterThan(0);
	}
	
}
