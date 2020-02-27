package com.revature.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.repositories.UserRepository;
import com.revature.services.UserService;

/**
 * UserServiceImpl handles any additional services that need to be made before calling the
 * repository methods.
 * 
 * @author Adonis Cabreja
 *
 */

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository ur;
	
	@Override
	public List<User> getActiveDrivers() {
		return ur.getActiveDrivers();
	}
	
	@Override
	public List<User> getUsers() {
		return ur.findAll();
	}
	
	@Override
	public User getUserById(int id) {
		return ur.findById(id).get();
	}
	
	@Override
	public List<User> getUserByUsername(String username) {
		return ur.getUserByUsername(username);
	}
	
	@Override
	public List<User> getUserByRole(boolean isDriver) {
		return ur.getUserByRole(isDriver);
	}
	
	@Override
	public List<User> getUserByRoleAndLocation(boolean isDriver, String location) {
		return ur.getUserByRoleAndLocation(isDriver, location);
	}
	
	@Override
	public User addUser(User user) {
		return ur.save(user);
	}
	
	@Override
	public User updateUser(User user) {
		return ur.save(user);
	}
	
	@Override
	public String deleteUserById(int id) {
		ur.deleteById(id);
		return "User with id: " + id + " was deleted.";
	}

}
