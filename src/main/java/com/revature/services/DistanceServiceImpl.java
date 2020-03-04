package com.revature.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import com.revature.entities.Employee;
import com.revature.services.EmployeeService;
import com.revature.services.ConfigurationService;


@Component
@Service
public class DistanceServiceImpl implements DistanceService {

	@Autowired
	EmployeeService es;

	@Autowired
	ConfigurationService cs;

	@Override
	public List<Employee> distanceMatrix(String[] origins, String[] destinations)
			throws ApiException, InterruptedException, IOException {
		Map<String, Employee> userDestMap = new HashMap<String, Employee>();

		List<String> destinationList = new ArrayList<String>();

		for (Employee d : es.getActiveDrivers()) {

			String address = d.getUser_address();

			destinationList.add(address);

			userDestMap.put(address, d);

		}

		destinations = new String[destinationList.size()];

		destinations = destinationList.toArray(destinations);

		GeoApiContext context = new GeoApiContext.Builder().apiKey(getGoogleMAPKey()).build();
		List<Double> arrlist = new ArrayList<Double>();
		DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);
		DistanceMatrix t = req.origins(origins).destinations(destinations).mode(TravelMode.DRIVING).units(Unit.IMPERIAL)
				.await();

		Map<Double, String> unsortMap = new HashMap<>();

		for (int i = 0; i < origins.length; i++) {
			for (int j = 0; j < destinations.length; j++) {
				try {
					System.out.println((j + 1) + "): " + t.rows[i].elements[j].distance.inMeters + " meters");
					arrlist.add((double) t.rows[i].elements[j].distance.inMeters);

					unsortMap.put((double) t.rows[i].elements[j].distance.inMeters, destinations[j]);

					System.out.println((double) t.rows[i].elements[j].distance.inMeters);

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

		Collections.sort(arrlist);

		System.out.println(arrlist);
		List<String> destList = new ArrayList<String>();

		arrlist.removeIf(r -> (arrlist.indexOf(r) > 4));

		Double[] arrArray = new Double[arrlist.size()];

		arrArray = arrlist.toArray(arrArray);

		System.out.println(arrArray);

		for (int c = 0; c < arrArray.length; c++) {
			String destination = unsortMap.get(arrArray[c]);
			destList.add(destination);
		}

		System.out.println(destList);

		String[] destArray = new String[destList.size()];

		destArray = destList.toArray(destArray);

		List<Employee> userList = new ArrayList<Employee>();

		for (int x = 0; x < destArray.length; x++) {
			Employee a = userDestMap.get(destArray[x]);
			System.out.println(a);
			userList.add(a);
			System.out.println(userList);
		}

		return userList;
	}

	@Override
	public String getGoogleMAPKey() {
		return cs.getConfigurationByLabel("API_KEY");
	}

	@Override
	public List<Employee> getDriverByLocation(String address) throws ApiException, InterruptedException, IOException {
		List<String> destinationList = new ArrayList<String>();
		String[] origins = { address };
		
		Map<String, Employee> topfive = new HashMap<String, Employee>();

		for (Employee d : es.getActiveDrivers()) {

			String a = d.getUser_address();

			destinationList.add(a);
			topfive.put(a, d);
		}

		String[] destinations = new String[destinationList.size()];
		destinations = destinationList.toArray(destinations);

		return distanceMatrix(origins, destinations);
	}

}
