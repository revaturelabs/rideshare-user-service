package com.revature.controllers;

import com.revature.services.InfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author May Love
 * 
 * InfoController handles requests to the REST service for information needed by
 * the front end that is not related to any bean class, such as the Google Maps
 * API key.
 */

@RestController
@CrossOrigin
@RequestMapping("/info")
@Api(tags={"information"})

public class InfoController {
    
        @Autowired
        InfoService infoService;
        
        @ApiOperation(value = "Fetches the Google Maps API key from environment"
                + " variables", tags="Information")
    	@GetMapping("/maps-api")
	public Map<String, String> getGoogleApi() {
		Map<String, String> info = new HashMap<>();
		 // fetches API key through InfoService
		String mapsKey = infoService.getGoogleMapsApiKey();
                 info.putIfAbsent("GOOGLE_MAPS_API_KEY", mapsKey);
                 return info;
	}
}
