package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	
	public void saveEmployee(Employee theEmployee);
	
	public Employee findById(int theId);
	
	public void deleteById(int theId);
	
}
