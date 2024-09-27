package com.synergytech.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.synergytech.entities.User;
import com.synergytech.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public Page<User> gerUsers(Pageable pageable){
		return userRepository.findAll(pageable);
	}
	
	

//	public List<User> getAllUsers() {
//		return userRepository.findAll();
//	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

}
