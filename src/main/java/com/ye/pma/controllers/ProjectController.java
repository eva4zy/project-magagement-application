package com.ye.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ye.pma.dao.EmployeeRepository;
import com.ye.pma.dao.ProjectRepository;
import com.ye.pma.entities.Employee;
import com.ye.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository emRepo;
	
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> project = (List<Project>) proRepo.findAll();
		model.addAttribute("projects", project);
		return "projects/list-projects";
	}
	
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		List<Employee> employees = (List<Employee>) emRepo.findAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project";
	}
	
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {		
		proRepo.save(project);	// save to the database
		// use a redirect to prevent duplicate submissions
		return "redirect:/projects";
		
	}
}
