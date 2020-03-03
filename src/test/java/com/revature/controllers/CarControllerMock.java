package com.revature.controllers;

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
import com.revature.entities.Car;
import com.revature.entities.Employee;
import com.revature.entities.Office;

@WebAppConfiguration
@EnableWebMvc
@AutoConfigureMockMvc
@SpringBootTest(classes = CarControllerMock.class)
public class CarControllerMock {

	@Autowired
	MockMvc mvc;

	@MockBean
	CarController cc;
	    
	@Test
	public void getCarById() throws Exception {

		Office office1 = new Office(1, "312 Railroad St.");
		Employee employee1 = new Employee(1, "yo@hotmail.com", "Joe", "Mack", "314-532-3145", "Bro123", "password",
				"123 Morgo town", true, true, false, false, office1);
		Car camry2015 = new Car(1, "Red", "Toyota", "Camry", 4, 2015, employee1);

		Mockito.when(cc.getCarById(1)).thenReturn(camry2015);

		ResultActions rs = mvc.perform(get("/cars/1").contentType(MediaType.APPLICATION_JSON).content(""));
		rs.andExpect(status().isOk());
		System.out.println(rs.andReturn().getResponse().getContentAsString());
	}

	@Test
	public void getCars() {

		Office office1 = new Office(1, "312 Railroad St.");
		Employee employee1 = new Employee(1, "yo@hotmail.com", "Joe", "Mack", "314-532-3145", "Bro123", "password",
				"123 Morgo town", true, true, false, false, office1);
		Car camry2015 = new Car(1, "Red", "Toyota", "Camry", 4, 2015, employee1);

		Office office2 = new Office(2, "315 Railroad St.");
		Employee employee2 = new Employee(2, "yso@hotmail.com", "Moe", "Mack", "314-532-3145", "Bros123", "password",
				"123 Morgo town", true, true, false, false, office2);
		Car camry2010 = new Car(2, "Red", "Toyota", "Camry", 4, 2015, employee2);

		List<Car> cars = new ArrayList<Car>();
		cars.add(camry2010);
		cars.add(camry2015);

		Mockito.when(cc.getCars()).thenReturn(cars);

		ResultActions rs;
		try {
			rs = mvc.perform(get("/cars").contentType(MediaType.APPLICATION_JSON).content(""));
			rs.andExpect(status().isOk());
			System.out.println(rs.andReturn().getResponse().getContentAsString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void addCar() throws JsonProcessingException {

		Office office1 = new Office(1, "312 Railroad St.");
		Employee employee1 = new Employee(1, "yo@hotmail.com", "Joe", "Mack", "314-532-3145", "Bro123", "password",
				"123 Morgo town", true, true, false, false, office1);
		Car camry2015 = new Car(1, "Red", "Toyota", "Camry", 4, 2015, employee1);

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(camry2015);
//		System.out.println(json);
		Mockito.when(cc.addCar(camry2015)).thenReturn(camry2015);

		ResultActions rs;
		try {
			rs = mvc.perform(post("/cars").contentType(MediaType.APPLICATION_JSON).content(json));
			rs.andExpect(status().isOk());
			System.out.println(rs.andReturn().getResponse().getContentAsString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void updateCar() throws Exception {

		Office office1 = new Office(1, "312 Railroad St.");
		Employee employee1 = new Employee(1, "yo@hotmail.com", "Joe", "Mack", "314-532-3145", "Bro123", "password",
				"123 Morgo town", true, true, false, false, office1);
		Car camry2015 = new Car(1, "Red", "Toyota", "Camry", 4, 2015, employee1);

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(camry2015);

		Mockito.when(cc.updateCar(camry2015)).thenReturn(camry2015);

		ResultActions rs = mvc.perform(put("/cars").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());
		System.out.println(rs.andReturn().getResponse().getContentAsString());
	}

}
