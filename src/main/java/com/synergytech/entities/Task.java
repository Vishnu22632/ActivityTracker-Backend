package com.synergytech.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private Long id;
	@Column(name = "task_name")
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(name = "task_status")
	private TaskStatus status;
	@Column(name = "task_desc")
	private String description;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	@ManyToOne
	@JoinColumn(name = "user_id") // Join column to establish the foreign key
	private User assignedUser;

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(Long id, String name, TaskStatus status, String description, Project project, User assignedUser) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.description = description;
		this.project = project;
		this.assignedUser = assignedUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", status=" + status + ", description=" + description
				+ ", project=" + project + ", assignedUser=" + assignedUser + "]";
	}

}
