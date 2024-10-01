package com.synergytech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergytech.entities.Project;
import com.synergytech.entities.User;
import com.synergytech.repositories.ProjectRepository;
import com.synergytech.repositories.UserRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	
	public List<Project> getAllProjects(){
		return projectRepository.findAll();
	}
	
	
	public Project saveProject(Project project) {
	 return projectRepository.save(project);
	}

	
	
}



