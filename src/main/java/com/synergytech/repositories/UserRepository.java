package com.synergytech.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.synergytech.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Page<User> findAll(Pageable pageable);
}

