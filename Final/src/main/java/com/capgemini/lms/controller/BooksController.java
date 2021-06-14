package com.capgemini.lms.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.lms.constants.BooksConstants;
import com.capgemini.lms.constants.SuccessMessage;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.ValidateBooksException;
import com.capgemini.lms.serviceimpl.Booksimpl;
	

	@RestController
	public class BooksController{
		@Autowired
		Booksimpl bs;
		
		@GetMapping("/getBooks")
		private List<Books> viewAllBooks(){
			return bs.viewAllBooks();
		}
		
		@DeleteMapping("/deleteBook/{bookid}")
		private SuccessMessage removeBook(@PathVariable("bookid") int bookid) throws BookNotFoundException{
			 bs.removeBook(bookid);
			 return new SuccessMessage(BooksConstants.BOOKS_DETAILS_REMOVED);
		}
		
		@PostMapping("/postBooks")
		private SuccessMessage saveBook(@RequestBody Books book) throws BookNotFoundException, ValidateBooksException {
			bs.addBook(book);
			return new SuccessMessage(BooksConstants.BOOKS_DETAILS_ADDED +book.getBookid());
		}
		
		@GetMapping("/getSubject/{subject}")
		private List<Books> searchBookBySubject(@PathVariable("subject") String keyword) throws BookNotFoundException{
			return bs.searchBookBySubject(keyword);
		}
		@GetMapping("/getTitle/{title}")
		private List<Books> searchBookByTitle(@PathVariable("title") String keyword) throws BookNotFoundException{
			return bs.searchBookByTitle(keyword);
		}
		
		@PutMapping("/updateBooks")
		private SuccessMessage update(@RequestBody Books book) throws BookNotFoundException, ValidateBooksException {
			bs.updateBookDetails(book);
			return new SuccessMessage(BooksConstants.BOOKS_DETAILS_UPDATED +book.getBookid());
		}
		
	}


