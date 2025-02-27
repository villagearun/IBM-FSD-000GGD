package comm.example.dao;

import java.util.List;

import comm.example.model.Employee;

public interface EmployeeDao {
	
	public void createEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
	public void getConnectionInfo();
}