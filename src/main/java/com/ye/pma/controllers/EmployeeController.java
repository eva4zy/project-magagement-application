package com.ye.pma.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ye.pma.dao.EmployeeRepository;
import com.ye.pma.entities.Employee;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository emRepo;
	
	@GetMapping
	public String displayEmployee(Model model) {
		List<Employee> employees = (List<Employee>) emRepo.findAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}
	
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee aEmployee = new Employee();
		model.addAttribute("employee", aEmployee);
		return "employees/new-employee";
	}
	
	
	@PostMapping("/save")
	public String createProject(Employee employee, Model model) {		
		emRepo.save(employee);	// save to the database
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees";
		
	}
}
