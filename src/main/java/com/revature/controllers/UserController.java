package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.maps.errors.ApiException;
import com.revature.beans.User;
import com.revature.services.BatchService;
import com.revature.services.DistanceService;
import com.revature.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

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
@Tag(name = "User", description = "User Controller")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@Autowired
	private BatchService bs;
	
	@Autowired
	private DistanceService ds;
	
	
	/*
	@GetMapping
	public List<User> getActiveDrivers() {
		return us.getActiveDrivers();
	}*/
	
	
	@Operation(summary = "Return five closest drivers", description="Returns five closest drivers", tags={"User"})
	@GetMapping(value = "/driver/{address}", produces = "application/json")
	public List <User> getTopFiveDrivers(@Parameter(description="User's Address", required=true)@PathVariable("address")String address) throws ApiException, InterruptedException, IOException {
		//List<User> aps =  new ArrayList<User>();
		System.out.println(address);
		List<String> destinationList = new ArrayList<String>();
		String [] origins = {address};
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
//		System.out.println(destinationList);
//		
		String [] destinations = new String[destinationList.size()];
////		
	destinations = destinationList.toArray(destinations);
//		
	return	ds.distanceMatrix(origins, destinations);
//		
//		
		//return ds.distanceMatrix();	
		
	}
	
	@Operation(summary="Return all users", description="Can also filter by is-driver, location, and username", tags={"User"})
    @GetMapping(produces="application/json")
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
	
	@Operation(summary = "Return specified user", description="Returns user by id", tags={"User"})
    @GetMapping(value = "/{id}", produces = "application/json")
	public User getUserById(@Parameter(description="Id of Admin", required=true) @PathVariable("id")int id) {
		
		return us.getUserById(id);
	}
	
	@Operation(summary = "Create user", description="Adds a new user", tags={"User"})
    @PostMapping(produces = "application/json")
	public Map<String, Set<String>> addUser(@Parameter(description="User to create", required=true) 
											@Valid @RequestBody(required=true) User user, 
											@Parameter(description="Field Errors to check", required=true) BindingResult result) {
		
		System.out.println(user.isDriver());
		 Map<String, Set<String>> errors = new HashMap<>();
		 
		 for (FieldError fieldError : result.getFieldErrors()) {
		      String code = fieldError.getCode();
		      String field = fieldError.getField();
		      if (code.equals("NotBlank") || code.equals("NotNull")) {	    	  
		    	  switch (field) {
		    	  case "userName":
		    		  errors.computeIfAbsent(field, key -> new HashSet<>()).add("Username field required");
		    		  break;
		    	  case "firstName":
		    		  errors.computeIfAbsent(field, key -> new HashSet<>()).add("First name field required");
		    		  break;
		    	  case "lastName":
		    		  errors.computeIfAbsent(field, key -> new HashSet<>()).add("Last name field required");
		    		  break;
		    	  case "wAddress":
		    		  errors.computeIfAbsent(field, key -> new HashSet<>()).add("Work address field required");
		    		  break;
		    	  case "wState":
		    	  case "hState":
		    		  errors.computeIfAbsent(field, key -> new HashSet<>()).add("State field required");
		    		  break;
		    	  case "phoneNumber":
		    		  errors.computeIfAbsent(field, key -> new HashSet<>()).add("Phone number field required");
		    		  break;
		    	  case "hAddress":
		    		  errors.computeIfAbsent(field, key -> new HashSet<>()).add("Home address field required");
		    		  break;
		    	  case "hZip":
		    	  case "wZip":
		    		  errors.computeIfAbsent(field, key -> new HashSet<>()).add("Zip code field required");
		    		  break;
		    	  case "hCity":
		    	  case "wCity":
		    		  errors.computeIfAbsent(field, key -> new HashSet<>()).add("City field required");
		    		  break;
		    	  default:
		    		  errors.computeIfAbsent(field, key -> new HashSet<>()).add(field+" required");
		    	  }
		      }
		      //username custom error message
		      else if (code.equals("Size") && field.equals("userName")) {
		          errors.computeIfAbsent(field, key -> new HashSet<>()).add("Username must be between 3 and 12 characters in length");
		      }
		      else if (code.equals("Pattern") && field.equals("userName")) {
		          errors.computeIfAbsent(field, key -> new HashSet<>()).add("Username may not have any illegal characters such as $@-");
		      }
		      else if (code.equals("Valid") && field.equals("userName")) {
		          errors.computeIfAbsent(field, key -> new HashSet<>()).add("Invalid username");
		      }
		      //first name custom error message
		      else if (code.equals("Size") && field.equals("firstName")) {
		          errors.computeIfAbsent(field, key -> new HashSet<>()).add("First name cannot be more than 30 characters in length");
		      }
		      else if (code.equals("Pattern") && field.equals("firstName")) {
		          errors.computeIfAbsent(field, key -> new HashSet<>()).add("First name allows only 1 space or hyphen and no illegal characters");
		      }
		      else if (code.equals("Valid") && field.equals("firstName")) {
		          errors.computeIfAbsent(field, key -> new HashSet<>()).add("Invalid first name");
		      }
		      //last name custom error message
		      else if (code.equals("Size") && field.equals("lastName")) {
		          errors.computeIfAbsent(field, key -> new HashSet<>()).add("Last name cannot be more than 30 characters in length");
		      }
		      else if (code.equals("Pattern") && field.equals("lastName")) {
		          errors.computeIfAbsent(field, key -> new HashSet<>()).add("Last name allows only 1 space or hyphen and no illegal characters");
		      }
		      else if (code.equals("Valid") && field.equals("lastName")) {
		          errors.computeIfAbsent(field, key -> new HashSet<>()).add("Invalid last name");
		      }
		      //email custom error messages
		      else if (code.equals("Email") && field.equals("email")) {
		              errors.computeIfAbsent(field, key -> new HashSet<>()).add("Invalid Email");
		      }
		      else if (code.equals("Pattern") && field.equals("email")) {
	              errors.computeIfAbsent(field, key -> new HashSet<>()).add("Invalid Email");
		      }
		      //phone number custom error messages
		      else if (code.equals("Pattern") && field.equals("phoneNumber")) {
	              errors.computeIfAbsent(field, key -> new HashSet<>()).add("Invalid Phone Number");
		      }
		    }

			if (errors.isEmpty()) {
				
				user.setBatch(bs.getBatchByNumber(user.getBatch().getBatchNumber()));
		 		us.addUser(user);
		 		

		 	}
		    return errors;
		
	}
	
	@Operation(summary = "Update specified user", description="Updates user", tags={"User"})
    @PutMapping(produces = "application/json")
	public User updateUser(@Parameter(description="Admin to update", required=true) @Valid @RequestBody(required=true) User user) {
		return us.updateUser(user);
	}
	
	@Operation(summary = "Delete specified user", description="Deletes user by id", tags={"User"})
    @DeleteMapping(value = "/{id}", produces = "application/json")
	public String deleteUserById(@Parameter(description="Id of Admin", required=true) @PathVariable("id")int id) {
		
		return us.deleteUserById(id);
	}
	
	
}
