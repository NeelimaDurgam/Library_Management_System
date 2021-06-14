package com.capgemini.lms.serviceimpl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.constants.BooksConstants;
import com.capgemini.lms.entities.Author;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.exception.AuthorNotFoundException;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.ValidateBooksException;
import com.capgemini.lms.repository.BooksRepository;
import com.capgemini.lms.service.BooksService;


@Service
public class Booksimpl implements BooksService{
	@Autowired
	BooksRepository br;
    
	/*
	 * Add books
	 */
	@Override
	public Books addBook(Books book) throws BookNotFoundException, ValidateBooksException {
			validateBooksDetails(book);
			br.save(book);
		    return book;	
	}
    
	/*
	 * Update book details
	 */
	@Override
	public Books updateBookDetails(Books book) throws BookNotFoundException, ValidateBooksException {
		Optional<Books> books = br.findById(book.getBookid());
		if(books.isPresent() && validateBooksDetails(book) == true) {
			return br.save(book);	
		}
		else {
			throw new BookNotFoundException("Book with ID :" + book.getBookid() + "doesn't exist");
		}		
     }  
	/*
	 * Remove book details
	 */
	@Override
	public int removeBook(int bookid) throws BookNotFoundException {
		Optional<Books> book = br.findById(bookid);
		if(!book.isPresent()) {
			throw new BookNotFoundException("The removed book id cannot be null");
		}
		else {
			br.deleteById(bookid);
			return bookid;
		}
	}

	/*
	 * Search book by title
	 */
	@Override
	public List<Books> searchBookByTitle(String keyword) throws BookNotFoundException{
		try {
			return br.searchBookByTitle(keyword);
		}catch(Exception e) {
			throw new BookNotFoundException("Search book by title not found");
		}	
	}
    /*
     * Search book by subject
     */
	@Override
	public List<Books> searchBookBySubject(String keyword) throws BookNotFoundException {
		try {
		return br.searchBookBySubject(keyword);		
		}catch(Exception e) {
			throw new BookNotFoundException("Search book by subject not found");
		}
	}
	
	/*
	 * view all books
	 */
	@Override
	public List<Books> viewAllBooks() {
		List<Books> result = new ArrayList<Books>();
        br.findAll().forEach(book1 -> result.add(book1));
        return result;
	}
	
	/*
	 * Validate book details
	 */
	public boolean validateBooksDetails(Books book ) throws ValidateBooksException {
		if (!book.getSubject().matches(("[a-zA-Z]+|[A-Za-z]+[ ]{1}[a-zA-Z]+"))) {
			throw new ValidateBooksException(BooksConstants.SUBJECT_CANNOT_BE_EMPTY);
		}
		if (!book.getTitle().matches(("[a-zA-Z]+|[A-Za-z]+[ ]{1}[a-zA-Z]+"))) {
			throw new ValidateBooksException(BooksConstants.TITLE_CANNOT_BE_EMPTY);
		}
		if (!book.getPublisher().matches("[a-zA-Z]+|[A-Za-z]+[ ]{1}[a-zA-Z]+")) {
			throw new ValidateBooksException(BooksConstants.PUBLISHER_CANNOT_BE_EMPTY);
		}
		String bookCostString=Double.toString(book.getBook_cost());
		if(!bookCostString.matches("[0-9]+([\\.][0-9]{1,2})?")) {
			throw new ValidateBooksException(BooksConstants.BOOK_COST_CANNOT_BE_EMPTY);
		}
		if (!book.getIsbn_code().matches("^[0-9]{5}")) {
			throw new ValidateBooksException(BooksConstants.ISBN_CODE_CANNOT_BE_EMPTY);
		}
		if(book.getQuantity()==0) {
			throw new ValidateBooksException(BooksConstants.QUANTITY_CANNOT_BE_EMPTY);
		}
		if (!book.getShelf_details().matches("[a-zA-Z]+|[A-Za-z]+[ ]{1}[a-zA-Z]+")) {
			throw new ValidateBooksException(BooksConstants.SHELF_DETAILS_CANNOT_BE_EMPTY);
		}
		if (!book.getAuthor().matches("[a-zA-Z]+|[A-Za-z]+[ ]{1}[a-zA-Z]+")) {
			throw new ValidateBooksException(BooksConstants.AUTHOR_NAME_CANNOT_BE_EMPTY);
		}
		
		return true;
	}
	

}
