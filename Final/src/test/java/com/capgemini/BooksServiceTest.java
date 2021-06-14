package com.capgemini;
import static org.assertj.core.api.Assertions.assertThat;



import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.capgemini.lms.entities.Books;

import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.ValidateBooksException;
import com.capgemini.lms.serviceimpl.Booksimpl;

public class BooksServiceTest extends FinalApplicationTests{
	@Autowired
	Booksimpl bs;
	@Test
	public void testAddBook()throws BookNotFoundException, ValidateBooksException{
		Books bk=new Books(27,"Jp","Machine","Mehatha",2022,"35463",36, 456.00,"Up","Machine");
		 bk = bs.addBook(bk);
		 assertEquals(27,bk.getBookid());
	}
	@Test
	public void testUpdateBookDetails() throws  BookNotFoundException, ValidateBooksException {
		Books bk=new Books(39,"Jp","Mechanics","Mehatha",2022,"35463",36, 456.00,"Up","Machine");
		 bk = bs.updateBookDetails(bk);
		 assertEquals("Mechanics",bk.getSubject());
	}
	@Test
	public void testRemoveBook() throws BookNotFoundException, ValidateBooksException{
		Books bk=new Books(41,"Jp","Machine","mehatha",2022,"35463",36, 456.00,"Up","Machine");
		 bk = bs.addBook(bk);
		 assertEquals(41,bs.removeBook(bk.getBookid()));
	}

	@Test
	public void testSearchBookByTitle() throws BookNotFoundException, ValidateBooksException {
		Books bk=new Books(27,"Jp","Machine","Mehatha",2022,"35463",36, 456.00,"Up","Machine");
		bk = bs.addBook(bk);
		assertEquals(bk.getTitle(),"Jp");
	}
	@Test
	public void testSearchBookBySubject() throws BookNotFoundException, ValidateBooksException {
		Books bk=new Books(27,"Jp","Machine","Mehatha",2022,"35463",36, 456.00,"Up","Machine");
		bk = bs.addBook(bk);
		assertEquals(bk.getSubject(),"Machine");
	}
	@Test
	public void testViewAllBooks() {
		List<Books> bk = bs.viewAllBooks();
		assertThat(bk).size().isGreaterThan(0);
	}
		
	}



