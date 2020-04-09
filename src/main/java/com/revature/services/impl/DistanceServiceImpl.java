package com.revature.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	@Autowired
	private UserService us;
	
	@Override
	public List<User> recommendDrivers(User rider, int count){
		
		List<User> activeUsers = us.getActiveDrivers();
		Map<String, User> driverAddresses = new HashMap<String, User>();
		
		String[] destinations = {rider.gethAddress(), rider.getwAddress()};
		String[] origins = new String[activeUsers.size() + 1];
		
		origins[0] = rider.gethAddress();
		List<String> driverAdds = getAddressFromUsers(activeUsers);
		for(int i = 0; i < driverAdds.size(); i++) {
			origins[i+1] = driverAdds.get(i);
			driverAddresses.put(driverAdds.get(i), activeUsers.get(i));
		}
		HashMap<String, Double> calcDistances;
		try {
			calcDistances = calculateDriverDistances(origins, destinations);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		Map<String, Double> sortedByValue = calcDistances.entrySet().stream()
				.sorted(Map.Entry.<String, Double>comparingByValue())
				.collect(toMap(Map.Entry::getKey,Map.Entry::getValue, (e1, e2) 
				-> e1, LinkedHashMap::new));
		
		List<User> finalList = new ArrayList<User>();
		//Set<String> allAddresses = calcDistances.keySet();
		for(int i = 0; i < count; i++)
			finalList[i] = driverAddresses.get(allAddreses);
			
			*/
		return null;
	}
	
	@Override
	public List<String> getAddressFromUsers( List<User> users){

		List<String> addresses= new ArrayList<String>();
		
		for( User u : users) {
			String add = u.gethAddress();
			String city = u.gethCity();
			String state = u.gethState();
				                                                                                                                                                                                                
			String fullAdd = add + ", " + city + ", " + state;
			addresses.add(fullAdd);
		}

		return addresses;
	}
	
	public HashMap<String, Double>calculateDriverDistances(String[] origins, String[] destinations) throws IOException, InterruptedException, ApiException{
		
		//Used to get the Key for the Google Map API and run the Calculator
		GeoApiContext getKey = new GeoApiContext.Builder().apiKey(getGoogleMAPKey()).build();
		DistanceMatrixApiRequest apiCall = DistanceMatrixApi.newRequest(getKey);
		DistanceMatrix distCalculator = apiCall.origins(origins).destinations(destinations)
	.mode(TravelMode.DRIVING).units(Unit.IMPERIAL).await();


		HashMap<String, Double> addressDistances = new HashMap<String, Double>();
		double DtoR;	//Distance :// Driver to Rider
		double RtoW;	//Distance :// Rider to Work
		double DtoW; // Distance :// Driver to Work
		double DtoRtoW; //Look into it a lil and you’ll may find what it means
		
		try {
			//Find the distance between Rider and Work
			RtoW = (double) distCalculator.rows[0].elements[1].distance.inMeters;

			//Calculate the distances for the Map
			for (int i = 0; i < origins.length;  i++) {
	
				//Find the distance between Driver [n] and Rider
				DtoR = (double) distCalculator.rows[i].elements[0].distance.inMeters;
	
				//Find the distance between Driver[n] and Work
				DtoW = (double) distCalculator.rows[i].elements[1].distance.inMeters;
				
				//Find total distance to Rider then Work 
				DtoRtoW = DtoR + RtoW;
	
				//Calculate the difference between Driving to Rider or Straight to Work
				double distCompare = DtoRtoW - DtoW;
	
				//Set values into the HashMap (Key-Origin,Value-Distance)
				addressDistances.put( origins[i], (Double)distCompare);
				
			}
		} catch (Exception e) {
			System.out.println("invalid address");
		}
		
	return addressDistances;

		
	}


	
	
	
	
	
	
	
	

	@Override	//Calculates all distances between all origins and all destinations
	public List<User> distanceMatrix(String[] origins, String[] destinations) throws ApiException, InterruptedException, IOException {
		
		//Maps each driver's home address to the driver
		Map<String, User> userDestMap = new HashMap<String, User>();
		
		//List of each driver's home address
		List<String> destinationList = new ArrayList<String>();
		
		//For each active driver, stores home address and mapping of driver to that address
		for(User d : us.getActiveDrivers()) {
			
			String add = d.gethAddress();
			String city = d.gethCity();
			String state = d.gethState();
			                                                                                                                                                                                                
			String fullAdd = add + ", " + city + ", " + state;
			
			destinationList.add(fullAdd);
			
			userDestMap.put(fullAdd, d);
						
		}
		
		//System.out.println(destinationList);
		
		 destinations = new String[destinationList.size()];

		//Puts destination list into a destination array
		destinations = destinationList.toArray(destinations);
		
		
		//An array to store distances
		List<Double> arrlist = new ArrayList<Double>();
		
		//Actually sends the request to the api, puts results into DistanceMatrix named t
		GeoApiContext context = new GeoApiContext.Builder().apiKey(getGoogleMAPKey()).build();
		DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);
		DistanceMatrix t = req.origins(origins).destinations(destinations).mode(TravelMode.DRIVING).units(Unit.IMPERIAL)
				.await();
		
		//Maps distance to destination
		Map< Double, String> unsortMap = new HashMap<>();
		
		for (int i = 0; i < origins.length; i++) { //For each starting point
			for (int j = 0; j < destinations.length; j++) { //For each destination
				try {
					System.out.println((j+1) + "): " + t.rows[i].elements[j].distance.inMeters + " meters"); //Display distances for each origin/destination combination
					arrlist.add((double) t.rows[i].elements[j].distance.inMeters); //Stores the distance
					
					unsortMap.put((double) t.rows[i].elements[j].distance.inMeters, destinations[j]); //Maps a distance to a destination
					
					System.out.println((double) t.rows[i].elements[j].distance.inMeters);	//Prints the same thing as above with less info
					
					
				} catch (Exception e) {
				System.out.println("invalid address");
				}
			}
		}
		
		
//		LinkedHashMap<String, Double> sortedMap = new LinkedHashMap<>();
//		unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
//                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
//		
		
		
		
		
		System.out.println("-");
		
		//Sorts and prints distances
		Collections.sort(arrlist);
		System.out.println(arrlist);
		
		List<String> destList = new ArrayList<String>();
		
		//Trims distances array to 5 shortest distances
	    arrlist.removeIf(r ->(arrlist.indexOf(r)>4));
	     
		//Creates an array to store the distances in	
		Double [] arrArray = new Double[arrlist.size()];
		arrArray = arrlist.toArray(arrArray);
		//Prints that distance array
		System.out.println(arrArray);
			
		//Loops through distance array, looks up address mapped to that distance and adds to destination list
		for(int c=0; c< arrArray.length; c++) {
			String destination = unsortMap.get(arrArray[c]); //This assumes no two can be the same distance
			destList.add(destination);
		}
		
		System.out.println(destList);
		
		
	
		
		
		
		
		//Makes destination array from destination list
		String [] destArray = new String[destList.size()];
		
		destArray = destList.toArray(destArray);
		
		List<User> userList = new ArrayList<User>();
		
		//Uses home address to map destination list back to the users
		for(int x=0; x< destArray.length; x++) {
			User a = userDestMap.get(destArray[x]);
			System.out.println(a);
			userList.add(a);
			System.out.println(userList);
		}
		
		//returns list of users, in theory, the 5 closest users by home addresses
		return userList;



	}
	
	public String getGoogleMAPKey() {
        Map<String, String> env = System.getenv();
        for (Map.Entry <String, String> entry: env.entrySet()) {
            if(entry.getKey().equals("googleMapAPIKey")) {
                return entry.getValue();
            }
        }
        return null;
    }
	
	
	

}