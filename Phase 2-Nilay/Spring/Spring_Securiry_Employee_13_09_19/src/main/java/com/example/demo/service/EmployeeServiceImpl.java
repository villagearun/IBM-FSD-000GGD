package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<Employee> getAllEmployees()
	{
		List<Employee> list=employeeRepository.findAll();
		return list;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		employeeRepository.save(theEmployee);
		
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result=employeeRepository.findById(theId);
		Employee theEmployee;
		
		if(result.isPresent())
		{
			theEmployee=result.get();
		}
		else
		{
			throw new RuntimeException("The Id is Invalid"+theId);
		}
		return theEmployee;
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
		
	}

}
