package com.revature.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;
import java.util.List;

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
import org.mockito.Mock;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@MockBean(BatchService.class)
@MockBean(DistanceService.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper om;
		
	@MockBean
	private UserService us;
        
        private User user;
        
        {
            /**
             * initialization block for test object
             * controllers will reject invalid objects due to JSR-303
             * annotation, so valid fields are provided by default
             * 
             * setters are used instead of constructor, as this provides more
             * clarity on how the object is being defined, and more flexibility
             * if the object is changed in the future
             */
            user = new User();
            user.setUserId(1);
            user.setUserName("aflorence");
            user.setFirstName("Alicia");
            user.setLastName("Florence");
            user.setEmail("alicia@yahoo.com");
            user.setPhoneNumber("4245551234");
            user.sethAddress("100 South St");
            user.sethCity("Marina del Rey");
            user.sethState("CA");
            user.sethZip("90292");
            user.setwAddress("879 S Olive St");
            user.setwCity("Los Angeles");
            user.setwState("CA");
            user.setwZip("90014");
            Batch b = new Batch();
            b.setBatchLocation("California");
            b.setBatchNumber(2020);
            user.setBatch(b);
        }
	
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
		
		user.setDriver(true);
		user.setActive(true);
		user.setAcceptingRides(true);
		when(us.getUserById(1)).thenReturn(user);
		
		mvc.perform(get("/users/{id}", 1))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$.userId").value(user.getUserId()));
	}
	
	@Test
	public void testGettingUserByUsername() throws Exception {
		
		List<User> users = new ArrayList<>();
		users.add(new User(1, "userName", new Batch(), "adonis", "cabreja", "adonis@gmail.com", "123-456-7890"));
		when(us.getUserByUsername("userName")).thenReturn(users);
		
		mvc.perform(get("/users?username=userName"))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$[0].userName").value("userName"));
	}
	
	@Test
	public void testGettingUserByRole() throws Exception {
		
		List<User> users = new ArrayList<>();
		User user = new User(1, "userName", new Batch(), "adonis", "cabreja", "adonis@gmail.com", "123-456-7890");
		user.setDriver(true);
		user.setActive(true);
		user.setAcceptingRides(true);
		users.add(user);
		when(us.getUserByRole(true)).thenReturn(users);
		
		mvc.perform(get("/users?is-driver=true"))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$[0].driver").value("true"));
	}
	
	@Test
	public void testGettingUserByRoleAndLocation() throws Exception {
		
		List<User> users = new ArrayList<>();
		User user = new User(1, "userName", new Batch(), "adonis", "cabreja", "adonis@gmail.com", "123-456-7890");
		user.setDriver(true);
		user.setActive(true);
		user.setAcceptingRides(true);
		users.add(user);
		when(us.getUserByRoleAndLocation(true, "location")).thenReturn(users);
		
		mvc.perform(get("/users?is-driver=true&location=location"))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$[0].driver").value("true"));
	}
	
	@Test
	public void testAddingUser() throws Exception {
		
		user.setDriver(true);
		user.setActive(true);
		user.setAcceptingRides(true);
		
		when(us.addUser(user)).thenReturn(user);
		
		mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(user)))
		   .andExpect(status().isCreated())
		   .andExpect(jsonPath("$.userName").value(user.getUserName()));
	}
	
	@Test
	public void testUpdatingUser() throws Exception {
		
		when(us.updateUser(user)).thenReturn(user);
		
		mvc.perform(put("/users/{id}", 1).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(user)))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$.userName").value(user.getUserName()));
	}
	
	@Test
	public void testDeletingUser() throws Exception {
		
		User user = new User(1, "userName", new Batch(), "adonis", "cabreja", "adonis@gmail.com", "123-456-7890");
		String returnedStr = "User with id: " + user.getUserId() + " was deleted.";
		when(us.deleteUserById(1)).thenReturn(returnedStr);
		
		mvc.perform(delete("/users/{id}", 1))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$").value(returnedStr));
	}
}
