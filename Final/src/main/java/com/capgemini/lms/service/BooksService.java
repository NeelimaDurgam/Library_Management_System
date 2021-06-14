package com.capgemini.lms.service;

	import java.util.List;

	import com.capgemini.lms.entities.Books;
    import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.ValidateBooksException;

	public interface BooksService {
		public Books addBook(Books book) throws BookNotFoundException,ValidateBooksException;
		public Books updateBookDetails(Books book) throws BookNotFoundException, ValidateBooksException;
		public int removeBook(int bookid) throws BookNotFoundException;
		public List<Books> searchBookByTitle(String keyword) throws BookNotFoundException;
		public List<Books> searchBookBySubject(String keyword) throws BookNotFoundException;
		public List<Books> viewAllBooks();
	}



