package com.capgemini.lms.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.lms.entities.Users;


public interface UsersRepository extends JpaRepository<Users,Integer> {

		
	}