package com.capgemini.lms.constants;

public class SuggestedBooksConstants {
	public static final String PATTERN ="([a-zA-Z]+|[A-Za-z]+[ ]{1}[a-zA-Z]+)";
	public static final String DATE_PATTERN = "(\\d{4}-\\d{2}-\\d{2})";
	

	public static final String TITLE_CANNOT_BE_EMPTY = "Title should not be empty and should contain only alphabets";
	public static final String SUBJECT_CANNOT_BE_EMPTY = "Subject should not be empty and should contain only alphabets";
	public static final String AUTHOR_CANNOT_BE_EMPTY = "Author Name should not be empty and should contain only alphabets";
	public static final String PUBLICATIONS_CANNOT_BE_EMPTY = "Name of publication should not be empty and should contain only alphabets";
	public static final String DESCRIPTION_CANNOT_BE_EMPTY = " Please add a description to the book!";
	public static final String DATE_INVALID = "Please enter the date in YYYY-MM-DD format only";
	public static final String STATUS_CANNOT_BE_EMPTY = "Please enter status - active or inactive";
	
	
	public static final String BOOK_SUGGESTION_ADDED = "Book added succesfully!";
	public static final String BOOK_UPDATED = "Book details updated succesfully";
}
