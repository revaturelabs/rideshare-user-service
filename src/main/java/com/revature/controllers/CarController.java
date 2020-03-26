package com.revature.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
@CrossOrigin(origins="http://localhost:4200")
@Api(tags= {"Car"})
public class CarController {
	
	@Autowired
	private CarService cs;
	
	/**
	 * HTTP GET method (/cars)
	 * 
	 * @return A list of all the cars.
	 */
	
	@ApiOperation(value="Returns all cars", tags= {"Car"})
	@GetMapping
	public List<Car> getCars() {
		
		return cs.getCars();
	}
	
	/**
	 * HTTP GET method (/cars/{number})
	 * 
	 * @param id represents the car's id.
	 * @return A car that matches the id.
	 */
	
	@ApiOperation(value="Returns car by id", tags= {"Car"})
	@GetMapping("/{id}")
	public Car getCarById(@PathVariable("id")int id) {
		
		return cs.getCarById(id);
	}
	
	/**
	 * HTTP GET method (/cars/users/{userId})
	 * 
	 * @param userId represents the user's id.
	 * @return A car that matches the user's id.
	 */
	
	@ApiOperation(value="Returns car by user id", tags= {"Car"})
	@GetMapping("/users/{userId}")
	public Car getCarByUserId(@PathVariable("userId")int userId) {
		
		return cs.getCarByUserId(userId);
	}
	
	/**
	 * HTTP POST method (/cars)
	 * 
	 * @param car represents the new Car object being sent.
	 * @return The newly created object with a 201 code.
	 */
	
	@ApiOperation(value="Adds a new car", tags= {"Car"})
	@PostMapping
	public ResponseEntity<Car> addCar(@Valid @RequestBody Car car) {
		
		return new ResponseEntity<>(cs.addCar(car), HttpStatus.CREATED);
	}
	
	/**
	 * HTTP PUT method (/cars)
	 * 
	 * @param car represents the updated Car object being sent.
	 * @return The newly updated object.
	 */
	
	@ApiOperation(value="Updates car by id", tags= {"Car"})
	@PutMapping
	public Map<String, Set<String>> updateCar(@Valid @RequestBody Car car, BindingResult result) {
		
		Map<String, Set<String>> errors = new HashMap<>();
		
		// Validation for car fields. Checks for empty input first, then checks input to match constraints. 
		for (FieldError fieldError : result.getFieldErrors()) {
		      String code = fieldError.getCode();
		      String field = fieldError.getField();
		      if (code.equals("NotBlank") || code.equals("NotNull")) {
		    	  switch (field) {
		    	  case "make":
		    		  errors.computeIfAbsent(field, key -> new HashSet<>()).add("Make field required");
		    		  break;
		    	  case "model":
		    		  errors.computeIfAbsent(field, key -> new HashSet<>()).add("Make field required");
		    		  break;
		    	  default:
		    		  errors.computeIfAbsent(field, key -> new HashSet<>()).add(field+" required");
		    	  }
		      }
		      
		      else if (code.equals("Size") && field.equals("make")) {
		          errors.computeIfAbsent(field, key -> new HashSet<>()).add("Make must be between 3 and 15 characters in length.");
		      }
		      else if (code.equals("Pattern") && field.equals("make")) {
		          errors.computeIfAbsent(field, key -> new HashSet<>()).add("Make only allows letters, spaces, and hyphens.");
		      }
		      else if (code.equals("Size") && field.equals("model")) {
		          errors.computeIfAbsent(field, key -> new HashSet<>()).add("Model must be between 1 and 25 characters in length.");
		      }
		      else if (code.equals("Pattern") && field.equals("model")) {
		          errors.computeIfAbsent(field, key -> new HashSet<>()).add("Model only allows letters, numbers, spaces, and hyphens.");
		      }
		}
		// If no errors are found.
		if (errors.isEmpty()) {

			cs.updateCar(car);
	 	}
		
		return errors;
	}
	
	/**
	 * HTTP DELETE method (/cars/{id})
	 * 
	 * @param id represents the car's id.
	 * @return A string that says which car was deleted.
	 */
	
	@ApiOperation(value="Deletes car by id", tags= {"Car"})
	@DeleteMapping("/{id}")
	public String deleteCarById(@PathVariable("id")int id) {
		
		return cs.deleteCarById(id);
	}
}
