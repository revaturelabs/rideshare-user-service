package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.entities.Employee;
import com.revature.entities.Office;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Integer> {

	public Employee findByUsername(String username);

	public List<Employee> findByIsDriver(boolean isDriver);

	public List<Employee> findByIsDriverAndOffice(boolean isDriver, Office office);
	
	public Employee findById(int id);
}
