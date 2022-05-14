package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employee -> employees.add(employee));
		return employees;
	}
	
	public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).get();
    }

    public void saveOrUpdate(Employee employee) {
        employeeRepository.save(employee);
    }
    
    public void update(Employee employee) {
    	Employee e = employeeRepository.getEmployeeById(employee.getId());
    	e.setName(employee.getName());
    	e.setSalary(employee.getSalary());
    	employeeRepository.save(e);
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
