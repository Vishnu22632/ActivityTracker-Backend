package com.synergytech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synergytech.entities.Project;
import com.synergytech.services.ProjectService;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@GetMapping
	public ResponseEntity<List<Project>> getAllProjects() {
		List<Project> projects = projectService.getAllProjects();
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}


	@PostMapping
	public ResponseEntity<Project> createOrUpdateProject(@RequestBody Project project) {
	    Project savedProject = projectService.saveProject(project);
	    return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
	}

}



