package com.revature.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

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
	
	
	//Grabs API key from environment variables
	public String getGoogleMAPKey() {
        Map<String, String> env = System.getenv();
        for (Map.Entry <String, String> entry: env.entrySet()) {
            if(entry.getKey().equals("googleMapAPIKey")) {
                return entry.getValue();
            }
        }
        return null;
    }
	
	@Override
	//Returns a list of users sorted by distance they would need to add to their commute to pick up the rider
	//Currently works under the assumption that they will work in the same building, but does not explicitly exclude drivers who don't
	public List<User> recommendDrivers(User rider, int recCount){
		
		List<User> activeDrivers = us.getActiveDrivers();

		String[] destinations = initDestinations(rider);
		String[] origins = initOrigins(rider, activeDrivers);
		
		//Iterates through list of drivers and removes rider (if there)
		for(User u : new ArrayList<User>(activeDrivers))
		{
			if (u.equals(rider)) {
				activeDrivers.remove(u);
			}
		}
		
		//List of the calculated ((DriverToRider+RiderToWork) - DriverToWork) aka added distances
		List<Double> calcDistances = new ArrayList<Double>();
		try {
			calcDistances = calculateDriverDistances(origins, destinations);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Mapping function below requires a final list/array 
		final List<Double> finCalcDistances = calcDistances;
		
		//This creates a new array, where sortedIndices[0] contains the index of the distance(and user) with shortest distance
		int[] sortedIndices = IntStream.range(0, finCalcDistances.size())
						.boxed().sorted((i,j) -> finCalcDistances.get(i).compareTo(finCalcDistances.get(j)))
						.mapToInt(ele -> ele).toArray();
		
		//List to store the top n users that will be returned
		List<User> sortedUsers = new ArrayList<User>();
		for (int i = 0; i < recCount; i++) {
			sortedUsers.add(activeDrivers.get(sortedIndices[i]));
		}
		
		return sortedUsers;
	}
	
	
	//Generates a string array for use with Google's DistanceMatrix
	public String[] initOrigins (User rider, List<User> activeDrivers) {
		String[] origins = new String[activeDrivers.size()+1];
		
		String riderHome = rider.gethAddress() + ", " + rider.gethCity()+ ", " + rider.gethState();
		origins[0] = riderHome;
		
		List<String> driverAdds = getAddressFromUsers(activeDrivers);
		for(int i = 0; i < driverAdds.size(); i++) {
			origins[i+1] = driverAdds.get(i);
		}
		
		return origins;
	}
	
	
	//Generates a string array for use with Google's DistanceMatrix
	public String[] initDestinations (User rider) {
		String riderHome = rider.gethAddress() + ", " + rider.gethCity()+ ", " + rider.gethState();
		String riderWork = rider.getwAddress() + ", " + rider.getwCity()+ ", " + rider.getwState();

		String[] destinations = {riderHome, riderWork};
		return destinations;
	}

	
	//Takes a list of user objects, concats their address and returns in a list
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
	
	//Method that makes the DistanceMatrix Api call and performs distance calculations
	public List<Double> calculateDriverDistances(String[] origins, String[] destinations) throws IOException, InterruptedException, ApiException{
		
		//Used to get the Key for the Google Map API and run the Calculator
		GeoApiContext getKey = new GeoApiContext.Builder().apiKey(getGoogleMAPKey()).build();
		DistanceMatrixApiRequest apiCall = DistanceMatrixApi.newRequest(getKey);
		DistanceMatrix distCalculator = apiCall.origins(origins).destinations(destinations)
	.mode(TravelMode.DRIVING).units(Unit.IMPERIAL).await();


		List<Double> distances = new ArrayList<Double>();
		double DtoR;	//Distance : Driver to Rider
		double RtoW;	//Distance : Rider to Work
		double DtoW; 	// Distance : Driver to Work
		double DtoRtoW; // Sum of DtoR and RtoW
		
		try {
			
			//Find the distance between Rider and Work
			RtoW = (double) distCalculator.rows[0].elements[1].distance.inMeters;
			
			for (int i = 1; i < origins.length;  i++) {
	

				//Sometimes the api would return null for an invalid address, causing whole system to crash
				//This catches null and sets the distance to a value that should prevent it from being recommended
				if (distCalculator.rows[i].elements[0].distance== null || distCalculator.rows[i].elements[1].distance == null) {
					System.out.println("Row " + i + "contains null");
					distances.add((double) 999999999);
				}
				else {
					
					//Distance from Driver's home to Rider's home
					DtoR = distCalculator.rows[i].elements[0].distance.inMeters;
					//Find the distance between Driver[n] and Work
					DtoW = (double) distCalculator.rows[i].elements[1].distance.inMeters;
					//Find total distance to Rider then Work 
					DtoRtoW = DtoR + RtoW;
		
					//Calculate the difference between Driving to Rider or Straight to Work
					double distCompare = DtoRtoW - DtoW;
					//Set values into the HashMap (Key-Origin,Value-Distance)
					distances.add((Double)distCompare);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return distances;

		
	}

	@Override
	public List<User> distanceMatrix(String[] origins, String[] destinations)
			throws ApiException, InterruptedException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	/*
	
	//Returns a list of 5 users, sorted by distance
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
	     
		//Creates an array to store the distances in (no reason to do this)
		Double [] arrArray = new Double[arrlist.size()];
		arrArray = arrlist.toArray(arrArray);
		System.out.println(arrArray);
			
		//Loops through distance array, looks up address mapped to that distance and adds to destination list
		for(int c=0; c< arrArray.length; c++) {
			String destination = unsortMap.get(arrArray[c]); //This assumes no two can be the same distance
			destList.add(destination);
		}
		
		System.out.println(destList);
		
		
		//Makes destination array from destination list (no reason to do this either)
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


		return userList;

	}

	*/

}