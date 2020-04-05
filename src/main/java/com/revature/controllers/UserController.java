package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.maps.errors.ApiException;
import com.revature.beans.User;
import com.revature.services.DistanceService;
import com.revature.services.UserService;
import com.revature.services.ValidationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * UserController takes care of handling our requests to /users.
 * It provides methods that can perform tasks like all users, user by role (true or false), user by username,
 * user by role and location, add user, update user and delete user by id. 
 * 
 * @author Adonis Cabreja
 *
 */

@RestController
@RequestMapping("/users")
@CrossOrigin
@Api(tags= {"User"})
@SessionAttributes(value= "user")

public class UserController {
    
    @Autowired
    private ValidationService validationService;
	
    @Autowired
    private UserService us;

    @Autowired
    private DistanceService ds;
	
	/**
	 * HTTP GET method (/users)
	 * 
	 * @param isDriver represents if the user is a driver or rider.
	 * @param username represents the user's username.
	 * @param location represents the batch's location.
	 * @return A list of all the users, users by is-driver, user by username and users by is-driver and location.
	 */
	
	@ApiOperation(value="Returns user drivers", tags= {"User"})
	@GetMapping("/driver/{address}/{work}/{range}/{sameOffice}")
	public List <User> getTopFiveDrivers(@PathVariable("address")String address, @PathVariable("work")String work, @PathVariable("range")Integer range, @PathVariable("sameOffice")Boolean sameOffice) throws ApiException, InterruptedException, IOException {

		List<User> driversGoingToSameBldg = new ArrayList<>();
		List<User> driversWithinXmiles = new ArrayList<>();
		List<User> defaultDriversList = new ArrayList<>();
		
		System.out.println("Range: "+range);
		System.out.println("Same Office: "+sameOffice);

		

		
		
		
		System.out.println(address);
		List<String> destinationList = new ArrayList<String>();
		String [] origins = {address};
		String [] workArr = {work};


	
//		
	    Map<String, User> topfive = new HashMap<String, User>();
//		
		for(User d : us.getActiveDrivers()) {
//			
			String add = d.gethAddress();
			String city = d.gethCity();
			String state = d.gethState();
			
			String fullAdd = add + ", " + city + ", " + state;
			
			destinationList.add(fullAdd);
//			
			topfive.put(fullAdd, d);
//						
	}
//		
//		
		String [] destinations = new String[destinationList.size()];
////		
	destinations = destinationList.toArray(destinations);
	
	
	//Generate list of driver going to same work address


	String wrk = work.substring(0, work.indexOf(','));
	
	System.out.println("Work Address: "+wrk);
	
	driversGoingToSameBldg = us.getActiveDriversByWorkAddress(wrk);

	//Drivers within 5 miles of location (Defaults to Home).
	driversWithinXmiles = ds.distanceMatrix(origins, workArr, destinations, range);
	
	
	//figure out default list
	for(User u : driversGoingToSameBldg) {
		for(User l : driversWithinXmiles) {
			if (u.equals(l)) {
				defaultDriversList.add(u);
			}
		}
	}
	
	
	System.out.println("Same Office: "+sameOffice);
	if (sameOffice.equals(false)) {
		
		System.out.println("In the if");

		
		return driversWithinXmiles;
	}
	
	
	

		return defaultDriversList;
		
	
	
	
	
	
	
	
//		
//		
		
	}
	
	/**
	 * HTTP GET method (/users)
	 * 
	 * @param isDriver represents if the user is a driver or rider.
	 * @param username represents the user's username.
	 * @param location represents the batch's location.
	 * @return A list of all the users, users by is-driver, user by username and users by is-driver and location.
	 */
	
	@ApiOperation(value="Returns all users", tags= {"User"}, notes="Can also filter by is-driver, location and username")
	@GetMapping
	public List<User> getUsers(@RequestParam(name="is-driver",required=false)Boolean isDriver,
							   @RequestParam(name="username",required=false)String username,
							   @RequestParam(name="location", required=false)String location) {
		
		if (isDriver != null && location != null) {
			return us.getUserByRoleAndLocation(isDriver.booleanValue(), location);
		} else if (isDriver != null) {
			return us.getUserByRole(isDriver.booleanValue());
		} else if (username != null) {
			return us.getUserByUsername(username);
		}
		
		return us.getUsers();
	}
	
	/**
	 * HTTP GET (users/{id})
	 * 
	 * @param id represents the user's id.
	 * @return A user that matches the id.
	 */
	
	@ApiOperation(value="Returns user by id", tags= {"User"})
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id")int id) {
		
		return us.getUserById(id);
	}
	
	/**
	 * HTTP POST method (/users)
	 * 
	 * @param user represents the new User object being sent.
	 * @return The newly created object with a 201 code.
	 * 
	 * Sends custom error messages when incorrect input is used
	 */
	
	@ApiOperation(value="Adds a new user", tags= {"User"})
	@PostMapping
	public ResponseEntity addUser(@Valid @RequestBody User user, BindingResult result) {
            Map<String, List<String>> errors = validationService.validate(result);
            if (errors.isEmpty()){
                    us.updateUser(user);
                    return ResponseEntity.status(HttpStatus.CREATED).body(errors);
            } 
            else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
	}
	
	/**
	 * HTTP PUT method (/users)
	 * 
	 * @param user represents the updated User object being sent.
	 * @return The newly updated object.
	 */
	
	@ApiOperation(value="Updates user by id", tags= {"User"})
	@PutMapping("/{id}")
	public ResponseEntity updateUser(@Valid @RequestBody User user, BindingResult result) {
            Map<String, List<String>> errors = validationService.validate(result);
            if (errors.isEmpty()){
                return ResponseEntity.ok(us.updateUser(user));
            } 
            else {
                return ResponseEntity.badRequest().body(errors);
            }
	}
	
	/**
	 * HTTP DELETE method (/users)
	 * 
	 * @param id represents the user's id.
	 * @return A string that says which user was deleted.
	 */
	
	@ApiOperation(value="Deletes user by id", tags= {"User"})
	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable("id")int id) {
		
		return us.deleteUserById(id);
	}
	
}
