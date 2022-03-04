package com.ye.pma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ye.pma.dao.EmployeeRepository;
import com.ye.pma.dao.ProjectRepository;

@SpringBootApplication
public class ProjectManagementApplication {

	@Autowired
	EmployeeRepository emRepo;
	
	@Autowired
	ProjectRepository proRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner() {
//		
//	};
}
