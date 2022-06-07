package com.example.demo.ripo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface Employee1 extends JpaRepository<Employee, Integer>{
	Employee getEmployeeById(int id);
}
