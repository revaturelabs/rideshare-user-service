package com.revature.controllers;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
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
		user.setDriver(true);
		user.setActive(true);
		user.setAcceptingRides(true);
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
		User user = new User(1, "userName", new Batch(), "adonis", "cabreja", "adonis@gmail.com", "123-456-789");
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
	public void testAddingValidUser() throws Exception {
		System.out.println("UPDATE");
		Batch batch = new Batch(111, "address");
		User user = new User(1, "gpichmann0", batch, "Grady", "Pichmann", "gpichmann0@artisteer.com", "212-374-3466", false, false, false, "5 Carpenter Plaza", "New York City", "10275", "NY", "30401 Esker Point", "Des Moines", "50347", "IA");
		String body = om.writeValueAsString(user);
		System.out.println(body);
		when(bs.getBatchByNumber(111)).thenReturn(batch);
		when(us.addUser(user)).thenReturn(user);
		
		mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(body).characterEncoding("utf-8"))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$").isEmpty());
	}
	
	@Test
	public void testAddingInvalidEmptyUser() throws Exception {
		
		Batch batch = new Batch(111, "address");
		User user = new User();
		user.setDriver(true);
		user.setActive(true);
		user.setAcceptingRides(true);
		
		verify(us, never()).addUser(user);
		
		mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(user)))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$").isNotEmpty());
;
	}
	
	@Test
	public void testAddingInvalidUser() throws Exception {
		String body = "{\r\n" + 
		"	\"userName\": \"a*************************************************************s\",\r\n" + 
		"	\"firstName\": \"asd  hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh     asd\",\r\n" + 
		"	\"lastName\": \"asd   hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh dsf\",\r\n" + 
		"	\"phoneNumber\": \"Invalid\",\r\n" + 
		"	\"email\": \"InvalidEmail\",\r\n" + 
		"	\"hZip\": \"sdfkjdfsfdsdfkj\"\r\n" + 
		"}";
		mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(body))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$").isNotEmpty());
	}
	
	
	@Test
	public void testUpdatingUser() throws Exception {
		System.out.println("UPDATE");
		Batch batch = new Batch(111, "address");

		User user = new User(1, "userName", batch, "adonis", "cabreja", "adonis@gmail.com", "123-456-789");
		String body = om.writeValueAsString(user);
		when(us.updateUser(user)).thenReturn(user);
		
		mvc.perform(put("/users/{id}", 1).contentType(MediaType.APPLICATION_JSON).content(body).characterEncoding("utf-8"))
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
