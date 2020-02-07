package com.revature.services;

import java.io.IOException;

import com.google.maps.errors.ApiException;

public interface DistanceService {
	
	
	public void  distanceMatrix(String[] origins, String[] destinations) throws ApiException, InterruptedException, IOException;

}
