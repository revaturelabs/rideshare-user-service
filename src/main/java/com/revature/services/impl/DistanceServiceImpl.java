package com.revature.services.impl;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import com.revature.beans.User;
import com.revature.services.DistanceService;
import com.revature.services.UserService;


@Service
public class DistanceServiceImpl implements DistanceService {
	
	Logger logger = Logger.getRootLogger();
	
	@Autowired
	private UserService us;

	@Override
	public List<User> distanceMatrix(String[] origins, String[] destinations) throws ApiException, InterruptedException, IOException {
		
		Map<String, User> userDestMap = new HashMap<String, User>();
		
		List<String> destinationList = new ArrayList<String>();
		
		for(User d : us.getActiveDrivers()) {
			
			String add = d.gethAddress();
			String city = d.gethCity();
			String state = d.gethState();
			
			
			
			String fullAdd = add + ", " + city + ", " + state;
			
			destinationList.add(fullAdd);
			
			userDestMap.put(fullAdd, d);
						
		}
		
		    logger.warn(destinationList);
		
		 destinations = new String[destinationList.size()];
//		
		destinations = destinationList.toArray(destinations);
		
		
		GeoApiContext context = new GeoApiContext.Builder().apiKey(getGoogleMAPKey()).build();
		List<Double> arrlist = new ArrayList<Double>();
		DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);
		DistanceMatrix t = req.origins(origins).destinations(destinations).mode(TravelMode.DRIVING).units(Unit.IMPERIAL)
				.await();
		
		Map< Double, String> unsortMap = new HashMap<>();

		for (int i = 0; i < origins.length; i++) {
			for (int j = 0; j < destinations.length; j++) {
				try {
					logger.warn((j+1) + "): " + t.rows[i].elements[j].distance.inMeters + " meters");
					arrlist.add((double) t.rows[i].elements[j].distance.inMeters);
					
					unsortMap.put((double) t.rows[i].elements[j].distance.inMeters, destinations[j]);
					
					logger.warn((double) t.rows[i].elements[j].distance.inMeters);
					
					
				} catch (Exception e) {
					logger.warn("invalid address");
				}
			}
		}
		
		
//		LinkedHashMap<String, Double> sortedMap = new LinkedHashMap<>();
//		unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
//                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
//		
		
		
		
		
		logger.warn("-");
		
		
		Collections.sort(arrlist);
		
		logger.warn(arrlist);
		List<String> destList = new ArrayList<String>();
		
	     arrlist.removeIf(r ->(arrlist.indexOf(r)>4));
	     
			
			Double [] arrArray = new Double[arrlist.size()];
			
			arrArray = arrlist.toArray(arrArray);
			
			logger.warn(arrArray);
			
			
			for(int c=0; c< arrArray.length; c++) {
				String destination = unsortMap.get(arrArray[c]);
				destList.add(destination);
			}
			
			logger.warn(destList);
		
		
	
		
		
		
		
		
		String [] destArray = new String[destList.size()];
		
		destArray = destList.toArray(destArray);
		
		List<User> userList = new ArrayList<User>();
		
		
		for(int x=0; x< destArray.length; x++) {
			User a = userDestMap.get(destArray[x]);
			logger.warn("User " + a);
			logger.warn("Destination " + x);
			userList.add(a);
			logger.warn(userList);
			logger.warn(destArray);
		}
		
		logger.warn(userList);
		return userList;



	}
	
	public String getGoogleMAPKey() {
        Map<String, String> env = System.getenv();
        for (Map.Entry <String, String> entry: env.entrySet()) {
            if(entry.getKey().equals("googleMapAPIKey")) {
                logger.warn("entry was a good map API key");
            	return entry.getValue();
            	
            }
        }
        logger.warn("entry was not a google map API key");	
        return null;
       
    }
	
	
	

}