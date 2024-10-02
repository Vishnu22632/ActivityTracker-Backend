package com.synergytech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergytech.entities.Task;
import com.synergytech.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> getAllTask(){
		return taskRepository.findAll();
	}
	
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}
	
}
