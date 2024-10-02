package com.synergytech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.synergytech.entities.Project;
import com.synergytech.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	
	public Page<Project> getAllProjects(int page,int size){
		return projectRepository.findAll(PageRequest.of(page, size));
	}
	
	
//	public List<Project> getAllProjects(){
//		return projectRepository.findAll();
//	}
	
	
	public Optional<Project> getProjectById(Long id) {
		return projectRepository.findById(id);
	}
	
	public Project saveProject(Project project) {
	 return projectRepository.save(project);
	}

	public void deleteProjectById(Long id) {
		projectRepository.deleteById(id);
	}
	
	
}



