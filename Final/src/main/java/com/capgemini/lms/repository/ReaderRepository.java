package com.capgemini.lms.repository;

import com.capgemini.lms.entities.Reader;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
 
public interface ReaderRepository extends JpaRepository<Reader, Integer>{
	
	//@Transactional
	//List<Reader> findAll();

	//Reader save(String readerId, String password);

}
