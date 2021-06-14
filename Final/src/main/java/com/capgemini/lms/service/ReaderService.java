package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.entities.Reader;
import com.capgemini.lms.exception.ReaderNotFoundException;
import com.capgemini.lms.exception.ValidateReaderException;

public interface ReaderService {
	public Reader register(Reader reader) throws ReaderNotFoundException, ValidateReaderException;
	public Reader updateReaderDetails(Reader reader) throws ReaderNotFoundException, ValidateReaderException;
	public int deleteReader(int id) throws ReaderNotFoundException ;
	public List<Reader> viewReadersList();
	public Reader viewReaderById(int id) throws ReaderNotFoundException;
	public Reader loginValidate(String readerId,String password) throws ReaderNotFoundException;
}
