package com.Jtemplte.Spring_Jtemplate_4_9_19.bean;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public final class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee employee=new Employee();
		employee.setId(rs.getInt(1));
		employee.setFname(rs.getString(2));
		employee.setLname(rs.getString(3));
		employee.setEmail(rs.getString(4));
		return employee;
	}

}
