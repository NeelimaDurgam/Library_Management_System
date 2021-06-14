package com.capgemini.lms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.lms.entities.*;

public interface BooksReturnedRepository extends JpaRepository<BooksReturned,Integer>{
}
