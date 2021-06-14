package com.capgemini.lms.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.lms.constants.ErrorMessage;
@RestControllerAdvice
public class AllExceptionAdvice {
	@ExceptionHandler(AuthorNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleAuthorException(AuthorNotFoundException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ValidateAuthorException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleAuthorException(ValidateAuthorException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleBookException(BookNotFoundException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ValidateBooksException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleBookException(ValidateBooksException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	
	@ExceptionHandler(ValidateIssueException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleBookIssueException(ValidateIssueException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	
	
	@ExceptionHandler(ValidateBooksReturnedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleReturnException(ValidateBooksReturnedException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	
	@ExceptionHandler(FeedbackNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleFeedbackException(FeedbackNotFoundException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ValidateFeedbackException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleFeedbackConstantException(ValidateFeedbackException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	
	@ExceptionHandler(PublisherNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handlePublisherException(PublisherNotFoundException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ValidatePublisherException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handlePublisherConstantException(ValidatePublisherException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	
	@ExceptionHandler(ReaderNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleReaderException(ReaderNotFoundException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ValidateReaderException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleReaderException(ValidateReaderException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	
	@ExceptionHandler(ValidateSuggestedBooksException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleBookSuggestedException(ValidateSuggestedBooksException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	
	@ExceptionHandler(AddressNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleAddressException(AddressNotFoundException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ValidateAddressException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleAddressValidateException(ValidateAddressException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleUserException(UserNotFoundException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ValidateUserException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleUserValidateException(ValidateUserException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}

}
