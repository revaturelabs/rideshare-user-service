package com.revature.controllers;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.aspects.LogIt;
import com.revature.entities.Car;
import com.revature.services.CarService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Component
@RestController
@RequestMapping("/cars")
@CrossOrigin
@Tag(name = "Car", description = "Car Controller")
public class CarController {

	@Autowired
	private CarService cs; 
	
	@Operation(summary= "Return list of all cars",description="Returns all cars", tags={"Car"})
	@GetMapping(produces = "application/json")
	public List<Car> getCars() {
		return cs.getCars();
	}
	
	@LogIt
	@Operation(summary = "Create car", description="Adds a new car", tags={"Car"})
	@PostMapping(produces = "application/json")
	public Car addCar(@Parameter(description="Car to add", required=true)@Valid @RequestBody(required=true) Car car) {
		return cs.addCar(car);
	}
	
	@LogIt
	@Operation(summary = "Update specified car", description="Updates car", tags={"Car"})
	@PutMapping(produces = "application/json")
	public Car updateCar(@Parameter(description="Car to update", required=true)@Valid @RequestBody(required=true) Car car) {
		return cs.updateCar(car);
	}
	
	// @LogIt
	// @Operation(summary = "Delete specified car", description="Deletes car", tags={"Car"})
	// @DeleteMapping(produces = "application/json")
	// public boolean deleteCar(@Parameter(description="Car to delete", required=true)@Valid @RequestBody(required=true) Car car) {
	// 	return cs.deleteCar(car);
	// }
	
	@LogIt
	@Operation(summary = "Delete specified car", description="Deletes car", tags={"Car"})
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public boolean deleteCar(@Parameter(description="Car to delete", required=true)@PathVariable("id")int id) {
		return cs.deleteCar(cs.getCarById(id));
	}
	
	@Operation(summary = "Return specified car", description="Returns car by id", tags={"Car"})
	@GetMapping(value = "/{id}", produces = "application/json")
	public Car getCarById(@Parameter(description="Id of Car", required=true) @PathVariable("id")int id) {
		return cs.getCarById(id);
	}
	
	
	@Operation(summary = "Return car by specified employee id", description="Returns car by employee id", tags={"Car"})
	@GetMapping(value = "/cars/{employeeId}", produces = "application/json")
	public Car getCarByEmployeeId(@Parameter(description="Id of Employee", required=true) @PathVariable("employeeId")int employeeId) {
		return cs.getCarByEmployeeId(employeeId).get(0);
	}
	
}
