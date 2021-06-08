package com.cognizant.spring.restapi.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring.restapi.dto.EmployeeDto;
import com.cognizant.spring.restapi.model.Employee;
import com.cognizant.spring.restapi.service.EmployeeService;

@RestController
public class EmployeeConroller {

	@Autowired
	EmployeeService service;
	
	@GetMapping("/emp")
	public Employee getEmp() {
		Employee e = new Employee();
		e.setDob(LocalDate.of(1998, 12, 01)  );
		e.setEmployeeName("Abhishek");
		e.setEmail("abhishek@gmail.com");
		return e;
	}

	@GetMapping("/hello")
	public String getHello() {
		Employee e = new Employee();
		return "hello";
	}	
	
//	/{"id":0,"employeeName":"Abhishek","email":"abhishek@gmail.com","dob":"2016-09-23"}
	
	@PostMapping("/employees")
	@ResponseStatus(code = HttpStatus.CREATED)
	public EmployeeDto addEmployee(@RequestBody Employee emp) {
		return service.addEmployee(emp);
	}

	@GetMapping(value = "/employees", consumes = "application/json", produces = "application/json")
	public List<EmployeeDto> getEmployees() {
		return service.getAllEmployee();
	}	 
	
	@GetMapping("/employees/emp-name/{employeeName}")
	public EmployeeDto getEmployee(@PathVariable String employeeName) {
		return service.getEmployeeByName(employeeName);
	}
	
	
	
	
	
	
	
	
	
	@DeleteMapping("/employees/id/{id}")
	public void deleteEmployee(@PathVariable("id") int id)   {
		service.deleteEmployee(id);
	}
	
	@GetMapping("/employees/id/{id}")
	public EmployeeDto getEmployee(@PathVariable("id") int id) {
		return service.getEmployeeById(id);
	}
	
	@PutMapping("/employees")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto emp)  {

			EmployeeDto empDto=service.updateEmployee(emp);
			return new ResponseEntity<EmployeeDto>(empDto, HttpStatus.ACCEPTED);
		
		
	}
	
	
	
	
	
	
	
	
	
}
