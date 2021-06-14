package com.capgemini.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.lms.entities.Books;

public interface BooksRepository extends JpaRepository<Books, Integer>{


	@Query("select b from Books b where b.subject = ?1")
	public List<Books> searchBookBySubject(String keyword);
	
	@Query("select b from Books b where b.title = ?1")
	public List<Books> searchBookByTitle(String keyword);


	

}
