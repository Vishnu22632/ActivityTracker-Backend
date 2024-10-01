package com.synergytech.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synergytech.entities.User;
import com.synergytech.services.UserService;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;


//	 Save user
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}


	
	
//	Get User by id
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		Optional<User> user = userService.getUserById(id);
		return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

	}
	
	
	
	@GetMapping
	public ResponseEntity<Page<User>> getAllUsers(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, @RequestParam(required = false) Long id,
			@RequestParam(required = false) String fullName, @RequestParam(required = false) String email,
			@RequestParam(required = false) String address) {
		Page<User> users = userService.getUsersWithFilters(id, fullName, email, address, PageRequest.of(page, size));
		return ResponseEntity.ok(users);
	}
	
	
//	@GetMapping
//	public ResponseEntity<List<User>> getUsers(){
//		List<User> users=userService.getUsers();
//		return new ResponseEntity<>(users,HttpStatus.OK);
//	}


//		Update user by id
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {

		if (userService.getUserById(id).isPresent()) {
			user.setId(id);
			User updatedUser = userService.saveUser(user);
			return ResponseEntity.ok(updatedUser);
		}

		return ResponseEntity.notFound().build();

	}

//	Delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		if (userService.getUserById(id).isPresent()) {
			userService.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
