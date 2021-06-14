package com.capgemini.lms.repository;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.SuggestedBooks;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
public interface SuggestedBooksRepository extends JpaRepository<SuggestedBooks, Integer>{

	
}
