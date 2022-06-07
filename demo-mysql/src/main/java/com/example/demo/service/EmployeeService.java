package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Address;
import com.example.demo.model.Employee;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	AddressRepository addressRepository;
	
	public String loginEmployee(Employee employee) {
		String eName = employee.getName();
		Double eSal = employee.getSalary();
		Employee e = employeeRepository.getEmployeeByNameOrSalary(eName, eSal);
		if(e != null) {
			Random random = new Random();
			int token = random.nextInt();
			return "User exist"+" Token : "+token;
		}
		return "User Does not exist";
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employees = employeeRepository.findAll();
//		employeeRepository.findAll().forEach(employee -> employees.add(employee));
		return employees;
	}
	
	public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public void saveOrUpdate(Employee employee) {
    	Address address = addressRepository.findById(employee.getAddress().getId());
    	employee.setAddress(address);
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
