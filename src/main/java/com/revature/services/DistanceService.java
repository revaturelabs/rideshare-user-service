package com.revature.services;

import java.io.IOException;
import java.util.List;
import com.google.maps.errors.ApiException;
import com.revature.beans.User;


public interface DistanceService {

	public List<User> distanceMatrix (String[] origins, String[] work, String[] destinations) throws ApiException, InterruptedException, IOException ;
	
}