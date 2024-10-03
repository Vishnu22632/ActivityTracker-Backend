package com.synergytech.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="project_id")
	private Long id;
	
	@Column(name="project_name")
	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name="project_desc")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="project_manager_id")
	private User project_manager;
	
	@Enumerated(EnumType.STRING)
	@Column(name="project_status")
	private ProjectStatus status;
	
	
	// Constructor , Getter and setter , toString method

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Project(Long id, String name, Date startDate, Date endDate, String description, User project_manager,
			ProjectStatus status) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.project_manager = project_manager;
		this.status = status;
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


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public User getProject_manager() {
		return project_manager;
	}


	public void setProject_manager(User project_manager) {
		this.project_manager = project_manager;
	}


	public ProjectStatus getStatus() {
		return status;
	}


	public void setStatus(ProjectStatus status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", description=" + description + ", project_manager=" + project_manager + ", status=" + status + "]";
	}

	

}
