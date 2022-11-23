package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.google.maps.errors.ApiException;
import com.revature.beans.Car;
import com.revature.beans.User;
import com.revature.services.CarService;
import com.revature.services.DistanceService;
import com.revature.services.UserService;

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
@CrossOrigin
@Api(tags= {"Car"})
public class CarController {
	
	@Autowired
	private CarService cs;
	
	@Autowired
	private DistanceService ds;
	
	@Autowired
	private UserService us;
	
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
	@PutMapping("/{id}")
	public ResponseEntity<Car>updateCar(@PathVariable(value="id") int carId, @Valid @RequestBody Car car) {
		
		
		return new ResponseEntity<> (cs.updateCar(car), HttpStatus.ACCEPTED);
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
	
	/**
	 * HTTP GET method (/cars/driver/{address})
	 * 
	 * @param address represents the users location.
	 * @return the top five closest drivers cars to the location.
	 */
	
	@ApiOperation(value="Returns user drivers", tags= {"User"})
	@GetMapping("/driver/{address}")
	public List <Car> getTopFiveDrivers(@PathVariable("address")String address) throws ApiException, InterruptedException, IOException {
		List<String> destinationList = new ArrayList<>();
		String [] origins = {address};
		
	    Map<String, User> topfive = new HashMap<>();
		
		for(User d : us.getActiveDrivers()) {
			
			if(cs.getCarByUserId(d.getUserId()) != null)
			{
			
			String add = d.gethAddress();
			String city = d.gethCity();
			String state = d.gethState();
			
			String fullAdd = add + ", " + city + ", " + state;
			
			destinationList.add(fullAdd);
			
			topfive.put(fullAdd, d);
			}
						
	}	
	String [] destinations = new String[destinationList.size()];
		
	destinations = destinationList.toArray(destinations);
	
	List<Car> carList = new ArrayList<>();
	
	for(User u: ds.distanceMatrix(origins, destinations)){
		carList.add(cs.getCarByUserId(u.getUserId()));
	}
	
	return	carList;	
		
	}
}
