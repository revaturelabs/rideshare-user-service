package com.revature.services;

import java.util.List;

import com.revature.entities.Office;

public interface OfficeService {

	public List<Office> getOffices();
	public Office getOfficeById(int id);
//	public List<Office> getOfficeByLocation(String location);
	public Office addOffice(Office office);
	public Office updateOffice(Office office);
	public boolean deleteOffice(Office office);
}
