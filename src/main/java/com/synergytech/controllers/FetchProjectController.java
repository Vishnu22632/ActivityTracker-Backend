package com.synergytech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synergytech.entities.Project;
import com.synergytech.repositories.ProjectRepository;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/api/all/projects")
public class FetchProjectController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@GetMapping
	public ResponseEntity<List<Project>> getProjects(){
		List<Project> projects = projectRepository.findAll();
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}
}
