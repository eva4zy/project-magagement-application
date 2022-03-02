package com.ye.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.ye.pma.entities.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
}
