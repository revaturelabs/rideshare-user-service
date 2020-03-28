package com.revature.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Batch;
import com.revature.beans.User;
import com.revature.services.BatchService;
import com.revature.services.DistanceService;
import com.revature.services.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper om;
		
	@MockBean
	private UserService us;
	
	@MockBean
	private BatchService bs;
	
	@MockBean
	private DistanceService ds;
	
	@Test
	public void testGettingUsers() throws Exception {
		
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		when(us.getUsers()).thenReturn(users);
		
		mvc.perform(get("/users"))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$", hasSize(2)));
	}
	
	@Test
	public void testGettingUserById() throws Exception {
		
		User user = new User(1, "userName", new Batch(), "adonis", "cabreja", "adonis@gmail.com", "123-456-789");
		user.setIsDriver(true);
		user.setActive(true);
		user.setIsAcceptingRides(true);
		when(us.getUserById(1)).thenReturn(user);
		
		mvc.perform(get("/users/{id}", 1))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$.userId").value(1));
	}
	
	@Test
	public void testGettingUserByUsername() throws Exception {
		
		List<User> users = new ArrayList<>();
		users.add(new User(1, "userName", new Batch(), "adonis", "cabreja", "adonis@gmail.com", "123-456-789"));
		when(us.getUserByUsername("userName")).thenReturn(users);
		
		mvc.perform(get("/users?username=userName"))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$[0].userName").value("userName"));
	}
	
	@Test
	public void testGettingUserByRole() throws Exception {
		
		List<User> users = new ArrayList<>();
		User user = new User(1, "userName", new Batch(), "adonis", "cabreja", "adonis@gmail.com", "123-456-789");
		user.setIsDriver(true);
		user.setActive(true);
		user.setIsAcceptingRides(true);
		users.add(user);
		when(us.getUserByRole(true)).thenReturn(users);
		
		mvc.perform(get("/users?is-driver=true"))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$[0].driver").value("true"));
	}
	
	@Test
	public void testGettingUserByRoleAndLocation() throws Exception {
		
		List<User> users = new ArrayList<>();
		User user = new User(1, "userName", new Batch(), "adonis", "cabreja", "adonis@gmail.com", "123-456-789");
		user.setIsDriver(true);
		user.setActive(true);
		user.setIsAcceptingRides(true);
		users.add(user);
		when(us.getUserByRoleAndLocation(true, "location")).thenReturn(users);
		
		mvc.perform(get("/users?is-driver=true&location=location"))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$[0].driver").value("true"));
	}
	
	@Test
	public void testAddingUser() throws Exception {
		
		Batch batch = new Batch(111, "address");
		User user = new User(1, "userName", batch, "adonis", "cabreja", "adonis@gmail.com", "123-456-7891");
		user.setIsDriver(true);
		user.setActive(true);
		user.setIsAcceptingRides(true);
		user.sethAddress("123 MyStreet Rd");
		user.sethCity("Tampa");
		user.sethState("FL");
		user.sethZip("33613");
		user.setwAddress("33613");
		user.setwZip("33613");
		user.setwCity("Tampa");
		user.setwState("FL");
		user.setwAddress("456 USF Ave");
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		System.out.println(violations);
		
		when(us.addUser(user)).thenReturn(user);
		
		mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(user)))
		   .andExpect(status().isCreated())
		   .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//		   .andExpect(jsonPath("$.userName").value("userName"));
	}
	
	@Test
	public void testUpdatingUser() throws Exception {
		
		Batch batch = new Batch(111, "address");
		User user = new User(1, "userName", batch, "adonis", "cabreja", "adonis@gmail.com", "123-456-7890");
		user.sethAddress("123 MyStreet Rd");
		user.sethCity("Tampa");
		user.sethState("FL");
		user.sethZip("33613");
		user.setwAddress("33613");
		user.setwZip("33613");
		user.setwCity("Tampa");
		user.setwState("FL");
		user.setwAddress("456 USF Ave");
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		System.out.println(violations);
		
		
		
		when(us.updateUser(user)).thenReturn(user);
		
		mvc.perform(put("/users", 1).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(user)))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$.userName").value("userName"));
	}
	
	@Test
	public void testDeletingUser() throws Exception {
		
		User user = new User(1, "userName", new Batch(), "adonis", "cabreja", "adonis@gmail.com", "123-456-789");
		String returnedStr = "User with id: " + user.getUserId() + " was deleted.";
		when(us.deleteUserById(1)).thenReturn(returnedStr);
		
		mvc.perform(delete("/users/{id}", 1))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$").value(returnedStr));
	}
}
