package com.revature.services;

import java.util.List;

import com.revature.beans.User;

public interface UserService {
	
	public List<User> getUsers();
	public User getUserById(int id);
	public List<User> getUserByUsername(String username);
	public List<User> getUserByRole(boolean isDriver);
	
	public User addUser(User user);
	public User updateUser(User user);
	public String deleteUserById(int id);
	//public Iterable<User> save(List<User> users);
	public List<User> getActiveDrivers();
}
