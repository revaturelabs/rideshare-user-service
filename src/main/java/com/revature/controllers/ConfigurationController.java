package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.revature.services.ConfigurationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Component
@RestController
@RequestMapping("/configurations")
@CrossOrigin
@Tag(name = "Configuration", description = "Configuration Controller")
public class ConfigurationController {

	@Autowired
	private ConfigurationService cs;
	
	@Operation(summary= "Return API key",description="Returns API key", tags={"Configuration"})
	@GetMapping(value = "/{labelId}")
	public String getConfiguration(@Parameter(description="Label", required=true) @PathVariable("labelId")String label) {
		String holder = cs.getConfigurationByLabel(label);
		Gson gson = new Gson();
		String response = gson.toJson(holder);
		System.out.println(response);
		return response;
	}
	
	
}
