package com.cognizant.spring.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.spring.rest.model.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

	List<Student> students = new ArrayList<Student>();
	
	@PostConstruct
	public void init() {
		students.add(new Student(101, "Virat", "virat.kholi@gmail.com", 32));
		students.add(new Student(102, "Rohit", "Rohit.sharma@gmail.com", 30));
		students.add(new Student(103, "Abhishek", "abishek.jain@gmail.com", 22));		
	}
	
	
	@GetMapping("/stu")
	public Student getStudent() {		
		return new Student(1, "Abhishek", "abhishekjain@gmail.com", 22);
	}

	@GetMapping("/students")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Student> getStudents() {		
		return students;
	}
	
	
	@PostMapping("/addstu")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Student addStudent(@RequestBody  Student stu) {
		students.add(stu);
		return stu;
	}
	
	@GetMapping("/stu/{name}")
	public Student searchByName(@PathVariable String name){		
		Student stu=students.stream().filter(s->s.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
		if(stu==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	   return stu;
	}
	
	
	
}
