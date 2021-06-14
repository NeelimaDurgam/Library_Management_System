package com.capgemini.lms.serviceimpl;
import com.capgemini.lms.repository.BooksReturnedRepository;
import com.capgemini.lms.service.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.lms.constants.BooksReturnedConstants;
import com.capgemini.lms.entities.BooksReturned;
import com.capgemini.lms.exception.*;
@Service
public class BooksReturnedServiceImp implements BooksReturnedService{
	@Autowired
	BooksReturnedRepository booksreturnedrepository;
	BooksReturned booksreturned;
	@Override
	public BooksReturned addReturnBooks(BooksReturned returned) throws ValidateBooksReturnedException {
		validateBooksReturned(returned);
		return booksreturnedrepository.save(returned);
	}
	@Override
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned) throws BookNotFoundException, ValidateBooksReturnedException{
		Optional<BooksReturned> findBooksReturnedById=this.booksreturnedrepository.findById(booksReturned.getId());
		if(findBooksReturnedById.isPresent() && validateBooksReturned(booksReturned)==true) {
			return booksreturnedrepository.save(booksReturned);	
			}
	else{
            throw new BookNotFoundException("ID :" + booksreturned.getId() + "doesn't exist");
	}
	}
	@Override
	public List<BooksReturned> viewReturnedBooksList() {
		List<BooksReturned> result = new ArrayList<BooksReturned>();
		booksreturnedrepository.findAll().forEach(booksreturned1 -> result.add(booksreturned1));
        return result;
		
	}
	public boolean validateBooksReturned(BooksReturned booksreturned ) throws ValidateBooksReturnedException {
		if (!booksreturned.getReturnedDate().matches(BooksReturnedConstants.DATE_PATTERN)) {
			throw new ValidateBooksReturnedException(BooksReturnedConstants.RETURNED_DATE_INVALID);
		}
		if (!booksreturned.getDelayed_Days().matches(BooksReturnedConstants.INTEGER_PATTERN)){
			throw new ValidateBooksReturnedException(BooksReturnedConstants.DELAYED_DAYS_INVALID);
		}
		if (!booksreturned.getPenalty().matches(BooksReturnedConstants.INTEGER_PATTERN)) {
			throw new ValidateBooksReturnedException(BooksReturnedConstants.PENALTY_INVALID);}
		if (!booksreturned.getPenalty_Status().matches("^[a-zA-Z]*$")) {
			throw new ValidateBooksReturnedException(BooksReturnedConstants.PENALTY_STATUS_INVALID);
			}	
		return true;
	}
	@Override
	public List<BooksReturned> viewDelayedBooksList() {
		List<BooksReturned> delayedbooks = new ArrayList<BooksReturned>();
		List <BooksReturned> bookslist = booksreturnedrepository.findAll();
		
			for(BooksReturned book1:bookslist) {
				 String delayed_days=book1.getDelayed_Days();
				 int days=Integer.valueOf(delayed_days);
				if (days>0) {
				delayedbooks.add(book1);	
				}	
		 	}
			return delayedbooks;
			}
	
}