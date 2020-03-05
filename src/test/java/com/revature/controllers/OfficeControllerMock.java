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
import com.revature.entities.Office;

@WebAppConfiguration
@EnableWebMvc
@AutoConfigureMockMvc
@SpringBootTest(classes = OfficeControllerMock.class)
public class OfficeControllerMock {
	
	@Autowired
	MockMvc mvc;

	@MockBean
	OfficeController oc;
	
	@Test
	public void getOfficeById() {

		Office office1 = new Office(1, "312 Railroad St.");

		Mockito.when(oc.getOfficeById(1)).thenReturn(office1);

		ResultActions rs;
		try {
			rs = mvc.perform(get("/offices/1").contentType(MediaType.APPLICATION_JSON).content(""));
			rs.andExpect(status().isOk());
			System.out.println(rs.andReturn().getResponse().getContentAsString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void getOffices() {

		Office office1 = new Office(1, "312 Railroad St.");
		Office office2 = new Office(2, "315 High St.");

		List<Office> offices = new ArrayList<Office>();
		offices.add(office1);
		offices.add(office2);

		Mockito.when(oc.getOffices()).thenReturn(offices);

		ResultActions rs;
		try {
			rs = mvc.perform(get("/offices").contentType(MediaType.APPLICATION_JSON).content(""));
			rs.andExpect(status().isOk());
			System.out.println(rs.andReturn().getResponse().getContentAsString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void addOffice() {

		Office office1 = new Office(1, "312 Railroad St.");
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		ResultActions rs;
		try {
			String json = ow.writeValueAsString(office1);
			Mockito.when(oc.addOffice(office1)).thenReturn(office1);
			rs = mvc.perform(post("/offices").contentType(MediaType.APPLICATION_JSON).content(json));
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
	public void updateoffice() {

		Office office1 = new Office(1, "312 Railroad St.");
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		ResultActions rs;
		try {
			String json = ow.writeValueAsString(office1);
			Mockito.when(oc.updateOffice(office1)).thenReturn(office1);
			rs = mvc.perform(put("/offices").contentType(MediaType.APPLICATION_JSON).content(json));
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
	public void deleteOffice() {
		
		Office office1 = new Office(1, "312 Railroad St.");
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		ResultActions rs;
		try {
			String json = ow.writeValueAsString(office1);
			Mockito.when(oc.deleteOffice(1)).thenReturn(true);
			rs = mvc.perform(delete("/offices/1").contentType(MediaType.APPLICATION_JSON).content(json));
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
}
