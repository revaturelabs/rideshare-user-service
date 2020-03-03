package com.revature.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.revature.entities.Car;
import com.revature.entities.Employee;
import com.revature.entities.Office;
import com.revature.services.CarService;

@AutoConfigureMockMvc
@SpringBootTest(
    classes = CarControllerMock.class
)
public class CarControllerMock {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	CarService cc;

	@Test
	public void getCarById(int id) throws Exception {
		
		Office office1 = new Office(1, "312 Railroad St.");		
		Employee employee1 = new Employee(1,"yo@hotmail.com", "Joe","Mack", "314-532-3145", "Bro123", "password", "123 Morgo town", true,true,false,false, office1);			
		Car camry2015 = new Car(1,"Red", "Toyota", "Camry", 4, 2015, employee1);
		
		Mockito.when(cc.getCarById(1)).thenReturn(camry2015);
		
		ResultActions rs = mvc.perform(get("/cars"));
		rs.andExpect(status().isOk());
		System.out.println(rs.andReturn().getResponse().getContentAsString());		
	}
	
	@Test
	public void getCars() {
		
		String json = "";
		Office office1 = new Office(1, "312 Railroad St.");		
		Employee employee1 = new Employee(1,"yo@hotmail.com", "Joe","Mack", "314-532-3145", "Bro123", "password", "123 Morgo town", true,true,false,false, office1);			
		Car camry2015 = new Car(1,"Red", "Toyota", "Camry", 4, 2015, employee1);
		
		Office office2 = new Office(2, "315 Railroad St.");		
		Employee employee2 = new Employee(2,"yso@hotmail.com", "Moe","Mack", "314-532-3145", "Bros123", "password", "123 Morgo town", true,true,false,false, office2);			
		Car camry2010 = new Car(2,"Red", "Toyota", "Camry", 4, 2015, employee2);
		
		List<Car> cars = new ArrayList<Car>();
		cars.add(camry2010);
		cars.add(camry2015);
		
		Mockito.when(cc.getCars()).thenReturn(cars);
				
		ResultActions rs;
		try {
			rs = mvc.perform(get("/cars").contentType(MediaType.APPLICATION_JSON_VALUE).content(json));
			rs.andExpect(status().isOk());
			System.out.println(rs.andReturn().getResponse().getContentAsString());	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
