package com.capgemini.lms.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lms.constants.ReaderConstants;
import com.capgemini.lms.constants.SuccessMessage;
import com.capgemini.lms.entities.Reader;
import com.capgemini.lms.entities.Reader;

import com.capgemini.lms.exception.ReaderNotFoundException;
import com.capgemini.lms.exception.ValidateReaderException;
import com.capgemini.lms.service.ReaderService;
import com.capgemini.lms.service.ReaderService;
@RestController
public class ReaderController {
	@Autowired
	ReaderService rs;
	/*
	 * Getting all the readers details
	 */
	
	@GetMapping("/allReaders")
	private List<Reader> viewReadersList(){
		return rs.viewReadersList();
	}
	/*
	 * Getting reader details by Id
	 */
	@GetMapping("/reader/{id}")
	private Reader viewReaderById(@PathVariable("id") int id) throws ReaderNotFoundException{
		return rs.viewReaderById(id);
	}
	/*
	 * Deleting reader details by Id
	 */
	@DeleteMapping("/deleteReader/{id}")
	private int deleteReader(@PathVariable("id") int id) throws ReaderNotFoundException{
		return rs.deleteReader(id);
	}
	/*
	 * Adding new reader
	 */
	@PostMapping("/addReader")
	private SuccessMessage saveReader(@RequestBody Reader reader) throws ReaderNotFoundException, ValidateReaderException {
		rs.register(reader);
		return new SuccessMessage(ReaderConstants.READER_REGISTERED + reader.getId());
	}
	/*
	 * Updating existing reader details
	 */
	@PutMapping("/updateReader")
	private SuccessMessage update(@RequestBody Reader reader) throws ReaderNotFoundException, ValidateReaderException {
		rs.updateReaderDetails(reader);
		return new SuccessMessage(ReaderConstants.READER_UPDATED + reader.getId());
	}
}
