package com.synergytech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synergytech.entities.User;
import com.synergytech.repositories.UserRepository;


@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/api/all")
public class FetchUserController {
	
	@Autowired
	private UserRepository userRepository;

	
		@GetMapping
		public ResponseEntity<List<User>> getUsers() {
		    List<User> users = userRepository.findAll();
		    return new ResponseEntity<>(users, HttpStatus.OK);
		}
	
}
