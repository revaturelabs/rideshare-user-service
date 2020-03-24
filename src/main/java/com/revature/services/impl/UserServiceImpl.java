package com.revature.services.impl;

import java.util.List;

import org.jboss.logging.Logger;
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
	Logger logger = Logger.getLogger(UserService.class);
	
	@Autowired
	private UserRepository ur;
	
	@Override
	public List<User> getActiveDrivers() {
	
		logger.trace("Getting all active drivers");
		return ur.getActiveDrivers();
	}
	
	/**
	 * Calls UserRepository's findAll method found in the JpaRepository.
	 * 
	 * @return A list of all the users.
	 */
	
	@Override
	public List<User> getUsers() {
		logger.trace("Finding all users");
		return ur.findAll();
	}

	/**
	 * Calls UserRepository's getOne method found in the JpaRepository.
	 * 
	 * @param id represents the user's id.
	 * @return A user that matches the id.
	 */
	
	@Override
	public User getUserById(int id) {
		logger.trace("getting user by id");
		return ur.findById(id).get();
	}
	
	/**
	 * Calls UserRepository's custom query method getUserByUsername.
	 * 
	 * @param username represents the user's username.
	 * @return A user that matches the username.
	 */
	
	@Override
	public List<User> getUserByUsername(String username) {
		logger.trace("Getting user by the parameter username");
		return ur.getUserByUsername(username);
	}
	
	/**
	 * Calls UserRepository's custom query method getUserByRole.
	 * 
	 * @param isDriver represents if the user is a driver or rider.
	 * @return A list of users by role.
	 */
	
	@Override
	public List<User> getUserByRole(boolean isDriver) {
		logger.trace("getting user by role of driver");
		return ur.getUserByRole(isDriver);
	}
	
	/**
	 * Calls UserRepository's custom query method getUserByRoleAndLocation.
	 * 
	 * @param isDriver represents if the user is a driver or rider.
	 * @param location represents the batch location.
	 * @return A list of users by isDriver and location.
	 */
	
	@Override
	public List<User> getUserByRoleAndLocation(boolean isDriver, String location) {
		logger.trace("getting users by role of driver and location");
		return ur.getUserByRoleAndLocation(isDriver, location);
	}
	
	/**
	 * Calls UserRepository's save method found in the JpaRepository.
	 * 
	 * @param user represents the new User object being sent.
	 * @return The newly created object.
	 */
	
	@Override
	public User addUser(User user) {
		logger.info("Adding user to database");
		return ur.save(user);
	}

	/**
	 * Calls UserRepository's save method found in the JpaRepository.
	 * 
	 * @param user represents the updated User object being sent.
	 * @return The newly updated object.
	 */
	
	@Override
	public User updateUser(User user) {
		logger.info("updating user information in the database");
		return ur.save(user);
	}

	/**
	 * Calls UserRepository's deleteById method found in the JpaRepository.
	 * 
	 * @param id represents the user's id.
	 * @return A string that says which user was deleted.
	 */
	
	@Override
	public String deleteUserById(int id) {
		logger.info("removing user from database based on ID");
		ur.deleteById(id);
		return "User with id: " + id + " was deleted.";
	}

}
