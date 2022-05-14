package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
//	@PostMapping("/add-employee")
//	public String createEmployee(@RequestBody Employee employee) {
//		employeeService.saveOrUpdate(employee);
//		return "Created";
//	}
	
	@PostMapping("/add-employee")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
		try {
			employeeService.saveOrUpdate(employee);
		} catch (Exception exception) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>("New Employee Created : "+ employee.getId(), HttpStatus.CREATED);
	}
}
