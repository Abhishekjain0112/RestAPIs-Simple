package com.cognizant.spring.restapi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.spring.restapi.dto.EmployeeDto;
import com.cognizant.spring.restapi.exception.EmployeeNotFoundException;
import com.cognizant.spring.restapi.model.Employee;
import com.cognizant.spring.restapi.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo repo;
	
	
	
	public Employee dtoToEmployee(EmployeeDto employeeDto) {
		
		Employee emp=new Employee();
		emp.setId(employeeDto.getId());
		emp.setDob(employeeDto.getDob());
		emp.setEmail(employeeDto.getEmail());
		emp.setEmployeeName(employeeDto.getEmployeeName());
		return emp;	
	}
	
	
	public EmployeeDto employeeToDto(Employee employee) {
		EmployeeDto empDto=new EmployeeDto();
		empDto.setId(employee.getId());
		empDto.setDob(employee.getDob());
		empDto.setEmail(employee.getEmail());
		empDto.setEmployeeName(employee.getEmployeeName());
		LocalDate today=LocalDate.now();
		int age=today.getYear()-employee.getDob().getYear();
		empDto.setAge(age);
		return empDto;
	}	
	
	@Override
	public EmployeeDto addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee savedEmployee=repo.save(employee);
		
		return employeeToDto(savedEmployee);
	
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	@Override
	public EmployeeDto getEmployeeById(int id) {
		// TODO Auto-generated method stub
		if(!repo.existsById(id)) {
			throw new EmployeeNotFoundException("Employee with ID ["+id+"] Not Found");
		}
		Employee employee=repo.getOne(id);
		
		return employeeToDto(employee);
	
	}

	@Override
	public EmployeeDto getEmployeeByName(String employeeName) {
		// TODO Auto-generated method stub
		Employee employee=repo.findByEmployeeName(employeeName);
		return employeeToDto(employee);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee=dtoToEmployee(employeeDto);
		Employee updatedEmployee=repo.save(employee);
		return employeeToDto(updatedEmployee);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		// TODO Auto-generated method stub
		List<EmployeeDto> employeeDtos=new ArrayList<EmployeeDto>();
		List<Employee> allEmployees=repo.findAll();
		for(Employee emp:allEmployees) {
			employeeDtos.add(employeeToDto(emp));
		}
		
		return employeeDtos;
	}


}
