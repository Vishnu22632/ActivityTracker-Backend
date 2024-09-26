package com.synergytech.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synergytech.entities.User;
import com.synergytech.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		Optional<User> user = userService.getUserById(id);
		return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

	}

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

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		if (userService.getUserById(id).isPresent()) {
			userService.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
