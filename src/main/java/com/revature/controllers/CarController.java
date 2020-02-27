package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.beans.Car;
import com.revature.services.CarService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * CarController takes care of handling our requests to /cars.
 * It provides methods that can perform tasks like all cars, car by id, car by user id, add car, update car and 
 * delete car by id.
 * 
 * @author Adonis Cabreja
 *
 */

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
	
	@Operation(summary = "Return specified car", description="Returns car by id", tags={"Car"})
	@GetMapping(value = "/{id}", produces = "application/json")
	public Car getCarById(@Parameter(description="Id of Car", required=true) @PathVariable("id")int id) {
		
		return cs.getCarById(id);
	}
	
	
	@Operation(summary = "Return car by specified user id", description="Returns car by user id", tags={"Car"})
	@GetMapping(value = "/users/{userId}", produces = "application/json")
	public Car getCarByUserId(@Parameter(description="Id of User", required=true) @PathVariable("userId")int userId) {
		
		return cs.getCarByUserId(userId);
	}
	
	
	@Operation(summary = "Create car", description="Adds a new car", tags={"Car"})
	@PostMapping(produces = "application/json")
	public ResponseEntity<Car> addCar(@Parameter(description="Admin to create", required=true)@Valid @RequestBody(required=true) Car car) {
		
		return new ResponseEntity<>(cs.addCar(car), HttpStatus.CREATED);
	}
	
	
	@Operation(summary = "Update specified car", description="Updates car by id", tags={"Car"})
	@PutMapping(value = "/{id}", produces = "application/json")
	public Car updateCar(@Parameter(description="Admin to create", required=true)@Valid @RequestBody(required=true) Car car) {
		
		return cs.updateCar(car);
	}
	
	@Operation(summary = "Delete specified car", description="Deletes car by id", tags={"Car"})
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public String deleteCarById(@PathVariable("id")int id) {
		
		return cs.deleteCarById(id);
	}
}
