package com.revature.services;

import java.util.List;

import com.revature.entities.Employee;
import com.revature.entities.Office;

public interface EmployeeService {

	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public Employee getEmployeeByUsername(String username);
	public List<Employee> getEmployeeByRole(boolean isDriver);
	public List<Employee> getEmployeeByRoleAndOffice(boolean isDriver, Office office);
	public Employee addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public boolean deleteEmployee(Employee employee);
	public List<Employee> getActiveDrivers();
	public Employee loginEmployee(String username, String password);
}
