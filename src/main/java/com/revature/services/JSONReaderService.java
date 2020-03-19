package com.revature.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReaderService {
	
	private static Logger logger = Logger.getLogger(JSONReaderService.class);
	
	// Method under construction
	public static Map<Integer, String> dataMapper() {
		JSONParser jsonParser = new JSONParser();
		FileReader dataReady = null;

		// Local Data for DEV ---> Same format as API json
		try {
			dataReady = new FileReader("src/main/resources/users_address.json"); 
		} catch (FileNotFoundException e) {
			logger.log(Level.ERROR, e.getMessage(), e);
		}
		
		Object obj = null; 
			try {
				obj = jsonParser.parse(dataReady);
				
			} catch (IOException | ParseException e) { 
				logger.log(Level.ERROR, e.getMessage(), e);
		}
		// Declare Map for loop
		Map<Integer, String> idAndStreets = new HashMap<Integer, String>();  
			
		JSONArray addressList = (JSONArray) obj;
//		System.out.println("\n... Reading in From addresses.json ...");
//		System.out.println(addressList);

		for (Object o : addressList) {
			JSONObject user = (JSONObject) o;
			// Convert userId from string to integer
			Long user_id = (Long) user.get("user_id");
			long u=user_id;  
			int intUser=(int)u;  

			// Concatenate street & zip
			String street = (String) user.get("h_address");
			String h_zip = (String) user.get("h_zip");
			String addrConcat = street + " "+ h_zip; 
			
			// Make Hash of userId/addresses PRE-distanceMatrix
			idAndStreets.put(intUser, addrConcat); // make map of id/streets
		}
		return idAndStreets;
		
	}
	
	public static ArrayList<Object> dataCleaner() {

		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		FileReader dataReady = null;

		// Local Data for DEV ---> Same format as API json
		try {
			dataReady = new FileReader("src/main/resources/users_address.json");

		} catch (FileNotFoundException | NullPointerException e) {
			logger.log(Level.ERROR, e.getMessage(), e);
		}
		
		Object obj = null;
		try {
			obj = jsonParser.parse(dataReady);

		} catch (IOException | ParseException e) {
			logger.log(Level.ERROR, e.getMessage(), e);
		} 

		ArrayList<Object> streets = new ArrayList<Object>();
        ArrayList<Object> newList = new ArrayList<Object>();
		JSONArray addressList = (JSONArray) obj;
		logger.info("Reading in From addresses.json");
		logger.info("\n Objects: ");

		for (Object o : addressList) {
			JSONObject user = (JSONObject) o;

			Long user_id = (Long) user.get("user_id");
			logger.info(user_id);
			
			String first_name = (String) user.get("first_name");
			String last_name = (String) user.get("last_name");
			String fullName = first_name + " " + last_name;
			logger.info(fullName); 

			String street = (String) user.get("h_address");
			String h_zip = (String) user.get("h_zip");
			String addrConcat = street + " "+ h_zip; 
			logger.info(addrConcat);
			  
			streets.add(addrConcat); // make array of streets
			newList.add(o);
			 
			 
//				// IN CASE WE STILL USE BATCH 
				// For getting batch with real users list
//				JSONArray batch = (JSONArray) user.get("batch");
//
//				for (Object b : batch) {
//					System.out.println(b + "");
//				}
		}

		return streets;

	}

}
