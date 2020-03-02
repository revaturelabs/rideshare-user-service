package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revature.entities.Office;
import com.revature.repositories.OfficeRepo;

@Component
@Service
public class OfficeServiceImpl implements OfficeService{
	
	@Autowired
	OfficeRepo or;

	@Override
	public List<Office> getOffices() {
		return (List<Office>) or.findAll();
	}

	@Override
	public Office getOfficeById(int id) {
		return or.findById(id).get();
	}

	@Override
	public Office addOffice(Office office) {
		return or.save(office);
	}

	@Override
	public Office updateOffice(Office office) {
		return or.save(office);
	}

	@Override
	public boolean deleteOffice(Office office) {
		or.delete(office);
		return true;
	}

}
