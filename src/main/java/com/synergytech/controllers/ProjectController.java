package com.synergytech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Page<Project>> getAllProjects(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {

		Page<Project> projects = projectService.getAllProjects(page, size);

		return new ResponseEntity<>(projects, HttpStatus.OK);

	}

//	@GetMapping
//	public ResponseEntity<List<Project>> getAllProjects() {
//		List<Project> projects = projectService.getAllProjects();
//		return new ResponseEntity<>(projects, HttpStatus.OK);
//	}

	@PostMapping
	public ResponseEntity<Project> createOrUpdateProject(@RequestBody Project project) {
		Project savedProject = projectService.saveProject(project);
		return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
	}

//	Delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable("id") Long id) {
		if (projectService.getProjectById(id).isPresent()) {
			projectService.deleteProjectById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
