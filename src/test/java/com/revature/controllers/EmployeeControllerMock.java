package com.revature.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.entities.Employee;
import com.revature.entities.Office;

@WebAppConfiguration
@EnableWebMvc
@AutoConfigureMockMvc
@SpringBootTest(classes = EmployeeControllerMock.class)
public class EmployeeControllerMock {

	@Autowired
	MockMvc mvc;

	@MockBean
	EmployeeController ec;
	
	@Test
	void login() {
		Office office1 = new Office(1, "312 Railroad St.");
		Employee employee1 = new Employee(1, "yo@hotmail.com", "Joe", "Mack", "314-532-3145", "Bro123", "password",
				"123 Morgo town", true, true, false, false, office1);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json;
		try {
			json = ow.writeValueAsString(employee1);
			Mockito.when(ec.login(employee1)).thenReturn(employee1);
			
			ResultActions rs = mvc.perform(post("/employees/login").contentType(MediaType.APPLICATION_JSON).content(json));
			rs.andExpect(status().isOk());
			System.out.println(rs.andReturn().getResponse().getContentAsString());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void addEmployee() {
		Office office1 = new Office(1, "312 Railroad St.");
		Employee employee1 = new Employee(1, "yo@hotmail.com", "Joe", "Mack", "314-532-3145", "Bro123", "password",
				"123 Morgo town", true, true, false, false, office1);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json;
		try {
			json = ow.writeValueAsString(employee1);
			Mockito.when(ec.addEmployee(employee1)).thenReturn(employee1);
			
			ResultActions rs = mvc.perform(post("/employees/register").contentType(MediaType.APPLICATION_JSON).content(json));
			rs.andExpect(status().isOk());
			System.out.println(rs.andReturn().getResponse().getContentAsString());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void getEmployees() {
		Office office1 = new Office(1, "312 Railroad St.");
		Employee employee1 = new Employee(1, "yo@hotmail.com", "Joe", "Mack", "314-532-3145", "Bro123", "password",
				"123 Morgo town", true, true, false, false, office1);
		
		Office office2 = new Office(2, "315 Railroad St.");
		Employee employee2 = new Employee(2, "yso@hotmail.com", "Moe", "Mack", "314-532-3145", "Bros123", "password",
				"123 Morgo town", true, true, false, false, office2);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);
		
		try {
			Mockito.when(ec.getEmployees()).thenReturn(employees);
			
			ResultActions rs = mvc.perform(get("/employees").contentType(MediaType.APPLICATION_JSON).content(""));
			rs.andExpect(status().isOk());
			System.out.println(rs.andReturn().getResponse().getContentAsString());
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void getEmployeeById() {
		Office office1 = new Office(1, "312 Railroad St.");
		Employee employee1 = new Employee(1, "yo@hotmail.com", "Joe", "Mack", "314-532-3145", "Bro123", "password",
				"123 Morgo town", true, true, false, false, office1);

		try {
			Mockito.when(ec.getEmployeeById(1)).thenReturn(employee1);
			
			ResultActions rs = mvc.perform(get("/employees/1").contentType(MediaType.APPLICATION_JSON).content(""));
			rs.andExpect(status().isOk());
			System.out.println(rs.andReturn().getResponse().getContentAsString());
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void updateEmployee() {
		Office office1 = new Office(1, "312 Railroad St.");
		Employee employee1 = new Employee(1, "yo@hotmail.com", "Joe", "Mack", "314-532-3145", "Bro123", "password",
				"123 Morgo town", true, true, false, false, office1);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json;
		try {
			json = ow.writeValueAsString(employee1);
			Mockito.when(ec.updateEmployee(employee1)).thenReturn(employee1);
			
			ResultActions rs = mvc.perform(put("/employees").contentType(MediaType.APPLICATION_JSON).content(json));
			rs.andExpect(status().isOk());
			System.out.println(rs.andReturn().getResponse().getContentAsString());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void deleteEmployee() {
		Office office1 = new Office(1, "312 Railroad St.");
		Employee employee1 = new Employee(1, "yo@hotmail.com", "Joe", "Mack", "314-532-3145", "Bro123", "password",
				"123 Morgo town", true, true, false, false, office1);
		
		try {
			Mockito.when(ec.deleteEmployee(employee1.getEmployee_id())).thenReturn(true);
			
			ResultActions rs = mvc.perform(delete("/employees/1").contentType(MediaType.APPLICATION_JSON).content(""));
			rs.andExpect(status().isOk());
			System.out.println(rs.andReturn().getResponse().getContentAsString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void getDriverByLocation() {
		Office office1 = new Office(1, "312 Railroad St.");
		Employee employee1 = new Employee(1, "yo@hotmail.com", "Joe", "Mack", "314-532-3145", "Bro123", "password",
				"123 Morgo town", true, true, false, false, office1);
		
		Office office2 = new Office(2, "315 Railroad St.");
		Employee employee2 = new Employee(2, "yso@hotmail.com", "Moe", "Pack", "314-532-3145", "Bros", "password",
				"123 Morgo town", true, true, true, false, office2);
		
		Office office3 = new Office(3, "318 Railroad St.");
		Employee employee3 = new Employee(3, "emp2@hotmail.com", "Toe", "Jack", "334-532-3145", "Bros13", "password",
				"123 Morgo town", true, true, true, false, office3);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee2);
		employees.add(employee3);
		
		try {
			Mockito.when(ec.getDriverByLocation(employee1.getUser_address())).thenReturn(employees);
			
			ResultActions rs = mvc.perform(get("/employees/driver/123 Morgo town").contentType(MediaType.APPLICATION_JSON).content(""));
			rs.andExpect(status().isOk());
			System.out.println(rs.andReturn().getResponse().getContentAsString());
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
