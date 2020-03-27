package com.revature.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.beans.dtos.LoginRequest;
import com.revature.services.DistanceService;
import com.revature.services.UserService;


@RestController
@CrossOrigin(origins= {"http://localhost:4200"}, methods= {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/v2/login")
public class LoginControllerV2 {
	@Autowired
	private UserService us;
	
	@Autowired
	private DistanceService ds;
	
	@PostMapping
	public User login(@RequestBody @Valid LoginRequest loginRequest) {
		return us.login(loginRequest);
	}
	
	@GetMapping("/getGoogleApi")
	public Map<String, Set<String>> getGoogleApi() {
		Map<String, Set<String>> info = new HashMap<>();
		 // getting API key
		 String newkey = ds.getGoogleMAPKey();
		 info.computeIfAbsent("googleMapAPIKey", key -> new HashSet<>()).add(newkey);
		 return info;
	}
	
}
