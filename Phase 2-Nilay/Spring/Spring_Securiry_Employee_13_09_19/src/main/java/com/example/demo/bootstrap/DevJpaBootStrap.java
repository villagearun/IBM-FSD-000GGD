package com.example.demo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;


@Controller
public class DevJpaBootStrap implements ApplicationListener<ContextRefreshedEvent> {

	private EmployeeRepository employeeRepository;
	

	public DevJpaBootStrap(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository=employeeRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		init();
	}

	private void init() {
		Employee employee=new Employee("Arun", "Kumar","arunksv@gmail.com", 100,30,30000,5);
		employeeRepository.save(employee);


	}

}