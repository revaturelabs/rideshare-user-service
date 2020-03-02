package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revature.entities.Employee;
import com.revature.entities.Office;
import com.revature.repositories.EmployeeRepo;

@Component
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo er;

	@Override
	public List<Employee> getEmployees() {
		return (List<Employee>) er.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return er.findById(id);
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		return er.findByUsername(username);
	}

	@Override
	public List<Employee> getEmployeeByRole(boolean isDriver) {
		return er.findByIsDriver(isDriver);
	}

	@Override
	public List<Employee> getEmployeeByRoleAndOffice(boolean isDriver, Office office) {
		return er.findByIsDriverAndOffice(isDriver, office);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(employee.getPassword());
		employee.setPassword(encryptedPassword);
		
		return er.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(employee.getPassword());
		employee.setPassword(encryptedPassword);
		
		return er.save(employee);
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		if (!(er.findById(employee.getEmployee_id()) == null)) {
			er.delete(employee);
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> getActiveDrivers() {
		List<Employee> employees = (List<Employee>) er.findAll();
		List<Employee> drivers = new ArrayList<Employee>();
		for (Employee e : employees) {
			if (e.isIs_active()) {
				drivers.add(e);
			}
		}
		return drivers;
	}

	@Override
	public Employee loginEmployee(String username, String password) {
		Employee e = er.findByUsername(username);
		if (e.getPassword().equals(password)) {
			return e;
		}
		else return null;
//		System.out.println("Employee " + e);
//		
//		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
//		
//		System.out.println(passwordEncryptor.checkPassword(password, e.getPassword()));
//		if (passwordEncryptor.checkPassword(password, e.getPassword())) {
//			System.out.println("This is returning correctly " + e);
//			return e;
//		}else {
//			System.out.println("This is returning null");
//			return null;
//		}
		
	}

}
