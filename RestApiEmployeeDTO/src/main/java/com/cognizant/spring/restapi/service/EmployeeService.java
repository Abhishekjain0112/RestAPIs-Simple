package com.cognizant.spring.restapi.service;

import java.util.List;

import com.cognizant.spring.restapi.dto.EmployeeDto;
import com.cognizant.spring.restapi.model.Employee;

public interface EmployeeService {

	
	public EmployeeDto addEmployee(Employee employee);
	public void deleteEmployee(int id);
	public EmployeeDto getEmployeeById(int id) ;
	
	public EmployeeDto getEmployeeByName(String employeeName);
	public EmployeeDto updateEmployee(EmployeeDto employee);
	public List<EmployeeDto> getAllEmployee();
	
	
	
}
