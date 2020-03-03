package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.maps.errors.ApiException;
import com.revature.entities.Employee;
import com.revature.logging.LogMaker;
import com.revature.services.DistanceService;
import com.revature.services.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Component
@RestController
@RequestMapping("/employees")
@CrossOrigin
@Tag(name = "Employee", description = "Employee Controller")
public class EmployeeController {

	@Autowired
	private EmployeeService es;
	
	@Autowired
	private DistanceService ds;

	@PostMapping(value = "/login")
	@Operation(summary = "Log in operation", description = "Returns employee", tags = { "Employee" })
	public Employee login(@RequestBody Employee employee) {
		return es.loginEmployee(employee.getUsername(), employee.getPassword());
	}
	
	@Operation(summary = "Add specified employee", description="Adds employee", tags={"Employee"})
    @PostMapping(value = "/register")
	public Employee addEmployee(@Parameter(description="Employee to add", required=true) @Valid @RequestBody(required=true) Employee employee) {
		LogMaker.writeLog("AddEmployee: " + employee.toString());
		return es.addEmployee(employee);
	}

	@Operation(summary = "Return all employees", description = "Returns all employees", tags = { "Employee" })
	@GetMapping(produces = "application/json")
	public List<Employee> getEmployees() {
		return es.getEmployees();
	}

	@Operation(summary = "Update specified employee", description = "Updates employee", tags = { "Employee" })
	@PutMapping(produces = "application/json")
	public Employee updateEmployee(
			@Parameter(description = "Employee to update", required = true) @Valid @RequestBody(required = true) Employee employee) {
		LogMaker.writeLog("UpdateEmployee: " + employee.toString());
		return es.updateEmployee(employee);
	}

	@Operation(summary = "Delete specified employee", description = "Deletes employee", tags = { "Employee" })
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public boolean deleteEmployee(
			@Parameter(description = "Employee to delete", required = true) @PathVariable("id") int id) {
		LogMaker.writeLog("DeleteEmployee: " + es.getEmployeeById(id).toString());
		return es.deleteEmployee(es.getEmployeeById(id));
	}

	@Operation(summary = "Return specified employee", description = "Returns user by id", tags = { "Employee" })
	@GetMapping(value = "/{id}", produces = "application/json")
	public Employee getEmployeeById(
			@Parameter(description = "Id of Employee", required = true) @PathVariable("id") int id) {
		return es.getEmployeeById(id);
	}

	@Operation(summary = "Return five closest drivers", description="Returns five closest drivers", tags={"Employee"})
	@GetMapping(value = "/driver/{address}", produces = "application/json")
	public List<Employee> getDriverByLocation(
			@Parameter(description = "Address of driver", required = true) @PathVariable("address") String address) throws ApiException, InterruptedException, IOException {
		return ds.getDriverByLocation(address);
		
	}

}
