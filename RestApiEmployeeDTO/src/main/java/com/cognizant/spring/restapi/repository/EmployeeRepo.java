package com.cognizant.spring.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.spring.restapi.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	
	Employee findByEmployeeName(String emolpyeeName);
	
	boolean existsByEmail(String email);
	
}
