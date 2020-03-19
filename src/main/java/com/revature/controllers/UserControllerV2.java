package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.maps.errors.ApiException;
import com.revature.beans.User;
import com.revature.beans.dtos.UserCreationRequest;
import com.revature.services.DistanceService;
import com.revature.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Refactor on {@link com.revature.controllers.UserController UserController} for development
 * without breaking changes to API consumers.  Will expose similar endpoints but with a contract
 * that allows for better data representation. Additionally, some methods will have reduced complexity
 * due to better usage of JSR-380 validation checking
 * 
 * @see com.revature.controllers.UserController UserController
 *
 */

@RestController
@RequestMapping("/v2/users")
@CrossOrigin
@Api(tags = { "User" })
public class UserControllerV2 {

	@Autowired
	private UserService us;

	@Autowired
	private DistanceService ds;

	/**
	 * HTTP GET method (/v2/users)
	 * 
	 * @param isDriver represents if the user is a driver or rider.
	 * @param username represents the user's username.
	 * @param location represents the batch's location.
	 * @return A list of all the users, users by is-driver, user by username and
	 *         users by is-driver and location.
	 */

	/*
	 * @ApiOperation(value="Returns user drivers", tags= {"User"})
	 * 
	 * @GetMapping public List<User> getActiveDrivers() { return
	 * us.getActiveDrivers(); }
	 */

	@ApiOperation(value = "Returns user drivers", tags = { "User" })
	@GetMapping("/driver/{address}")
	public List<User> getTopFiveDrivers(@PathVariable("address") String address)
			throws ApiException, InterruptedException, IOException {
		List<String> destinationList = new ArrayList<String>();
		String[] origins = { address };
		Map<String, User> topfive = new HashMap<String, User>();
		for (User d : us.getActiveDrivers()) {
			String add = d.gethAddress();
			String city = d.gethCity();
			String state = d.gethState();

			String fullAdd = add + ", " + city + ", " + state;

			destinationList.add(fullAdd);
			topfive.put(fullAdd, d);
		}
		String[] destinations = new String[destinationList.size()];
		destinations = destinationList.toArray(destinations);
		return ds.distanceMatrix(origins, destinations);

	}

	/**
	 * HTTP GET method (/users)
	 * 
	 * @param isDriver represents if the user is a driver or rider.
	 * @param username represents the user's username.
	 * @param location represents the batch's location.
	 * @return A list of all the users, users by is-driver, user by username and
	 *         users by is-driver and location.
	 */

	@ApiOperation(value = "Returns all users", tags = {
			"User" }, notes = "Can also filter by is-driver, location and username")
	@GetMapping
	public List<User> getUsers(@RequestParam(name = "is-driver", required = false) Boolean isDriver,
			@RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "location", required = false) String location) {

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
	@ApiOperation(value = "Returns user by id", tags = { "User" })
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") int id) {

		return us.getUserById(id);
	}

	/**
	 * HTTP POST method (/users)
	 * 
	 * @param userRequest represents the new User object being sent.
	 * @return The newly created object with a 201 code.
	 * 
	 *   Creates {@link com.revature.beans.User User} given a request payload.
	 *   Will send standard Validation errors upon validation failure.
	 *   
	 *   @see com.revature.beans.User
	 */
	@ApiOperation(value = "Adds a new user", tags = { "User" })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public User addUser(@Valid @RequestBody UserCreationRequest userRequest, BindingResult result) {
		return us.addUser(userRequest);
	}

	/**
	 * HTTP PUT method (/users)
	 * 
	 * @param user represents the updated User object being sent.
	 * @return The newly updated object.
	 */
	@ApiOperation(value = "Updates user by id", tags = { "User" })
	@PutMapping
	public User updateUser(@Valid @RequestBody User user) {
		return us.updateUser(user);
	}

	/**
	 * HTTP DELETE method (/users)
	 * 
	 * @param id represents the user's id.
	 * @return A string that says which user was deleted.
	 */
	@ApiOperation(value = "Deletes user by id", tags = { "User" })
	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable("id") int id) {

		return us.deleteUserById(id);
	}

}
