package com.Jtemplte.Spring_Jtemplate_4_9_19.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao {
	
	
	//private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void createEmployee(Employee employee)
	{
		String query="insert into employee(id,firstName,lastName,email) values(?,?,?,?)";
		Object obj[]= {employee.getId(),employee.getFname(),employee.getLname(),employee.getEmail()};
		jdbcTemplate.update(query,obj);
		System.out.println("done");
	}
	
	public List<Employee> getAllEmployee()
	{
		return jdbcTemplate.query("select * from employee", new EmployeeRowMapper());
	}
	public void deleteEmployee(int id)
	{
		String query="delete from employee where id="+id;
		jdbcTemplate.update(query);
		System.out.println("Delete is done");
	}

}
