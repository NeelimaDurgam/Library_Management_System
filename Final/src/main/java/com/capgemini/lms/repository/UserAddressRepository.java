package com.capgemini.lms.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.lms.entities.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress,Integer>{

}
