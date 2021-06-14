package com.capgemini.lms.constants;

public class ReaderConstants {
	
	public static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
	public static final String NAME_PATTERN ="([a-zA-Z]+|[A-Za-z]+[ ]{1}[a-zA-Z]+)";
	public static final String EMAIL_PATTERN = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	public static final String PHONENUMBER_PATTERN	= "[1-9][0-9]{9}";
	
	public static final String PASSWORD_INVALID = "Password invalid!";
	public static final String NAME_CANNOT_BE_EMPTY1 = "First Name should not be empty and should contain only alphabets";
	public static final String NAME_CANNOT_BE_EMPTY2 = "Last Name should not be empty and should contain only alphabets ";
	public static final String MOBILE_NUMBER_CANNNOT_BE_EMPTY = "Mobile Number should not be empty and should contain only numbers";
	public static final String EMAIL_CANNOT_BE_EMPTY = "Email address is invalid!";
	public static final String READER_REGISTERED = "Reader succesfully registered";
	public static final String READER_UPDATED = "Reader details updated succesfully";
	
	
	
	

}
