package com.revature.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.DistanceService;
import com.revature.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


/**
 * LoginController takes userName  and Password. 
 * 
 * @author Bertrick Lappa
 */

@RestController
@CrossOrigin
@RequestMapping("/login")
@Tag(name = "Login", description = "Login Controller")
public class LoginController {
	
	@Autowired
	private UserService us;
	
	@Autowired
	private DistanceService ds;
	
	@GetMapping//("/{userName}/{passWord}")
	@Operation(summary = "Log in operation", description="Returns id and name of user", tags={"User"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful Operation"),
			@ApiResponse(responseCode = "500", description = "Internal Servor Error")})
	public Map<String, Set<String>> login(
							   @RequestParam(name="userName")String userName,
							   @RequestParam(name="passWord")String passWord) {
		
		System.out.println(userName);
		Map<String, Set<String>> errors = new HashMap<>();
		if(userName.length() == 0) {
		       errors.computeIfAbsent("userName", key -> new HashSet<>()).add("userName required!");
		}
		/*if((userName == null || userName.equals("") || passWord.isEmpty())) {
		       errors.computeIfAbsent("passWord", key -> new HashSet<>()).add("passWord required!");
		}*/
		if (errors.isEmpty()) {
			Map<String, Set<String>> info = new HashMap<>();
			//call login service here
			List<User> u=us.getUserByUsername(userName);
			if(u.size() != 0) {
			   info.computeIfAbsent("name", key -> new HashSet<>()).add(u.get(0).getFirstName()+" "+u.get(0).getLastName());
			   info.computeIfAbsent("userid", key -> new HashSet<>()).add(u.get(0).getUserId()+"");
			}else {
				info.computeIfAbsent("userNotFound", key -> new HashSet<>()).add("User not found!");
			}
			return info;
		}else {
			 return errors;
		}
	}
	
	@GetMapping(value = "/getGoogleApi")
	@Operation(summary = "Get Google API", description="Retrieves Google API")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful Operation"),
			@ApiResponse(responseCode = "500", description = "Internal Servor Error")})
	public Map<String, Set<String>> getGoogleApi() {
		Map<String, Set<String>> info = new HashMap<>();
		 // getting API key
		 String newkey = ds.getGoogleMAPKey();
		 info.computeIfAbsent("googleMapAPIKey", key -> new HashSet<>()).add(newkey);
		 return info;
	}
	
}
