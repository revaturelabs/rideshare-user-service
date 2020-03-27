package com.revature.services;

import java.util.List;

import javax.validation.Valid;

import com.revature.beans.User;
import com.revature.beans.dtos.LoginRequest;
import com.revature.beans.dtos.UserCreationRequest;

public interface UserService {
	
	public List<User> getUsers();
	public User getUserById(int id);
	public List<User> getUserByUsername(String username);
	public List<User> getUserByRole(boolean isDriver);
	public List<User> getUserByRoleAndLocation(boolean isDriver, String location);
	public User addUser(UserCreationRequest userCreationRequest);
	public User updateUser(User user);
	public String deleteUserById(int id);
	public List<User> getActiveDrivers();
	public User login(@Valid LoginRequest loginCredentials);
}
