package com.capgemini;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.capgemini.lms.entities.Author;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.exception.AuthorNotFoundException;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.ValidateAuthorException;
import com.capgemini.lms.serviceimpl.AuthService;
import com.capgemini.lms.serviceimpl.Booksimpl;


public class AuthServiceTest extends FinalApplicationTests{
	@Autowired
	AuthService as;
	@Autowired 
	Booksimpl bb;
	Books books;
	
	@Test
	public void testDeleteAuthorDetails() throws AuthorNotFoundException, ValidateAuthorException, BookNotFoundException{
		books=new Books(129,"Jp","Machine","Mehatha",2022,"35465",36, 456.0,"Up","Machine");
		List<Books> bl=new ArrayList<Books>();
		bl.add(books);
		//bl=bb.addBook(books);
		Author np=new Author(19,"Mohana","Neelarapu","ng@gmail.com","7492801893",bl);
		np = as.addAuthorDetails(np);
		assertEquals(19,as.deleteAuthorDetails(np.getAuthorId()));
		//assertEquals(456.0,bl.getBook_cost());
		//assertNotNull(bl);
	}
	
	@Test
	public void testViewAuthorsList() {
		List<Author> auth = as.viewAuthorsList();
		assertThat(auth).size().isGreaterThan(0);
	}
	
	@Test
	public void testAddAuthorDetails() throws AuthorNotFoundException,ValidateAuthorException,BookNotFoundException{
		books=new Books(129,"Jp","Machine","Mehatha",2022,"35465",36, 456.00,"Up","Machine");
		List<Books> bl=new ArrayList<Books>();
		bl.add(books);
		Author auth = new Author(4,"Mohana","Neelarapu","ng@gmail.com","7492801345",bl);
		auth = as.addAuthorDetails(auth);
		//assertNotNull(auth);
		assertEquals(auth.getFirstName(),"Mohana");
    }
	
	@Test
	public void testUpdateAuthorDetails() throws AuthorNotFoundException, ValidateAuthorException,BookNotFoundException {
		books=new Books(129,"Jp","Machine","Mehatha",2022,"35465",36, 456.00,"Up","Machine");
		List<Books> bl=new ArrayList<Books>();
		bl.add(books);
		Author auth = new Author(22,"Mohana","Neelarapu","mk@gmail.com","8739130198",bl);
		auth = as.updateAuthorDetails(auth);
		assertEquals(auth.getLastName(), "Neelarapu"); 
		assertEquals(auth.getEmail(),"mk@gmail.com"); 
	}
	@Test 
	public void testViewAuthorById() throws AuthorNotFoundException, ValidateAuthorException,BookNotFoundException {
		books=new Books(129,"Jp","Machine","Mehatha",2022,"35465",36, 456.00,"Up","Machine");
		List<Books> bl=new ArrayList<Books>();
		bl.add(books);
		Author auth=new Author(5,"Mohana","Neelarapu","mk@gmail.com","8739130198",bl);
		Author np=as.addAuthorDetails(auth);
		assertEquals(np.getAuthorId(),5);
	}
}
