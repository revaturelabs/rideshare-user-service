package com.revature.services.impl;

import org.springframework.stereotype.Service;

import com.revature.services.DistanceService;



import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;

import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit; 


@Service
public class DistanceServiceImpl implements DistanceService {
	
	private static final String API_KEY = "AIzaSyATbV5Em-m8ZtrBiDgCG1oFlNjNxV3r8M4";

	@Override
	public void distanceMatrix(String[] origins, String[] destinations) throws ApiException, InterruptedException, IOException {
		
		
		GeoApiContext context = new GeoApiContext.Builder().apiKey(API_KEY).build();
		List<Double> arrlist = new ArrayList<Double>();
		DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);
		DistanceMatrix t = req.origins(origins).destinations(destinations).mode(TravelMode.DRIVING).units(Unit.IMPERIAL)
				.await();

		for (int i = 0; i < origins.length; i++) {
			for (int j = 0; j < destinations.length; j++) {
				try {
					System.out.println((j+1) + "): " + t.rows[i].elements[j].distance.inMeters + " meters");
					arrlist.add((double) t.rows[i].elements[j].distance.inMeters);
				} catch (Exception e) {
				System.out.println("invalid address");
				}
			}
		}
		System.out.println("-");
		Collections.sort(arrlist);
		System.out.println("SORTED: " + arrlist.toString());

//		int i = 0;
//		for (double x : arrlist) {
//			i++;
//			System.out.println(i + "): " + x / 1609 + " miles");
//		}

	}
	return arrlist;

}
