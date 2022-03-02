package com.ye.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.ye.pma.entities.Project;

// a mechanism to access data in database 
public interface ProjectRepository extends CrudRepository<Project, Long>{
	
}
