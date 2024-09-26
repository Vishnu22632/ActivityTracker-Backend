package com.synergytech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergytech.entities.User;
import com.synergytech.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(Long id){
		return userRepository.findById(id);
	}
	
	
	public void deleteById(Long id) {
		 userRepository.deleteById(id);
	}
	
	
	
}
