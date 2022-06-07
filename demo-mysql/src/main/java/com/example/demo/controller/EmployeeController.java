package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    private List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    private Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/create-employee")
    private ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        try {
            employeeService.saveOrUpdate(employee);
        } catch (Exception exception) {
            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>("New employee created with id: " + employee.getId(), HttpStatus.CREATED);
    }
    
    @PostMapping("/login-employee")
    private String loginEmployee(@RequestBody Employee employee) {
    	return employeeService.loginEmployee(employee);
    }
    
    // Add employees bulk create
//    @PostMapping("/create-employees")
//    private ResponseEntity<?> createEmployees(@RequestBody Employee employee) {
//        try {
//            employeeService.saveOrUpdate(employee);
//        } catch (Exception exception) {
//            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<Object>("New employee created with id: " + employee.getId(), HttpStatus.CREATED);
//    }
    
    @PutMapping("/update-employee")
    private ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
    	try {
    		employeeService.update(employee);
    	} catch (Exception exception) {
    		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	return new ResponseEntity<Object>("Employee ID : "+ employee.getId() +" updated", HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    private ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        try {
            employeeService.delete(id);
        } catch (Exception exception) {
            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>("Employee deleted with id: " + id, HttpStatus.OK);
    }
	
}
