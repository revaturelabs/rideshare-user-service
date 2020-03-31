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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.revature.beans.User;
import com.revature.services.UserService;

/**
 * LoginController takes userName and Password.
 * 
 * @author Bertrick Lappa
 */

@RestController
@CrossOrigin
@RequestMapping("/login")
@SessionAttributes(value = "user")
public class LoginController {

	@Autowired
	private UserService us;

	@GetMapping
	public Map<String, Set<String>> login(@RequestParam(name = "userName") String userName,
			@RequestParam(name = "passWord") String passWord) {

		System.out.println(userName);
		Map<String, Set<String>> errors = new HashMap<>();
		if (userName.length() == 0) {
			errors.computeIfAbsent("userName", key -> new HashSet<>()).add("userName required!");
		}
		/*
		 * if((userName == null || userName.equals("") || passWord.isEmpty())) {
		 * errors.computeIfAbsent("passWord", key -> new
		 * HashSet<>()).add("passWord required!"); }
		 */
		if (errors.isEmpty()) {
			Map<String, Set<String>> info = new HashMap<>();
			// call login service here

			List<User> u = us.getUserByUsername(userName);
			if (u.size() != 0) {

				;
				info.computeIfAbsent("name", key -> new HashSet<>())
						.add(u.get(0).getFirstName() + " " + u.get(0).getLastName());
				info.computeIfAbsent("userid", key -> new HashSet<>()).add(u.get(0).getUserId() + "");
				info.computeIfAbsent("wAddress", key -> new HashSet<>())
						.add(u.get(0).getwAddress() + ", " + u.get(0).getwCity() + ", " + u.get(0).getwState());
				info.computeIfAbsent("hAddress", key -> new HashSet<>())
						.add(u.get(0).gethAddress() + ", " + u.get(0).gethCity() + ", " + u.get(0).gethState());

			} else {
				info.computeIfAbsent("userNotFound", key -> new HashSet<>()).add("User not found!");
			}
			return info;
		} else {
			return errors;
		}
	}

}
