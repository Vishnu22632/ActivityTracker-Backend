package com.synergytech.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.synergytech.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	 @Query("SELECT u FROM User u WHERE " +
	           "(:id IS NULL OR u.id = :id) AND " +
	           "(:fullName IS NULL OR LOWER(u.fullName) LIKE LOWER(CONCAT('%', :fullName, '%'))) AND " +
	           "(:email IS NULL OR LOWER(u.email) LIKE LOWER(CONCAT('%', :email, '%'))) AND " +
	           "(:address IS NULL OR LOWER(u.address) LIKE LOWER(CONCAT('%', :address, '%')))")
	  
	 Page<User> findByFilters(
	            @Param("id") Long id,
	            @Param("fullName") String fullName,
	            @Param("email") String email,
	            @Param("address") String address,
	            Pageable pageable);
	 

	
	
}

