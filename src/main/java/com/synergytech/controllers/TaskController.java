package com.synergytech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.synergytech.entities.Task;
import com.synergytech.entities.User;
import com.synergytech.services.TaskService;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public ResponseEntity<List<Task>> getAllTasks(){
		List<Task> tasks=taskService.getAllTask();
		return new ResponseEntity<>(tasks,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Task> saveTask(@RequestBody Task task){
		Task savedTask = taskService.saveTask(task);
		return new ResponseEntity<>(savedTask,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{id}")
		public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @RequestBody Task task){
			if(taskService.getTaskById(id).isPresent()) {
				task.setId(id);
				Task updatedTask = taskService.saveTask(task);
				return ResponseEntity.ok(updatedTask);
			}
			return ResponseEntity.notFound().build();
		}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id){
		
		if(taskService.getTaskById(id).isPresent()) {
			taskService.deleteTaskById(id);
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	
}
