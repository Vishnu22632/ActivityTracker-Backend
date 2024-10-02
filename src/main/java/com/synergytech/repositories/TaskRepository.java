package com.synergytech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergytech.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}



