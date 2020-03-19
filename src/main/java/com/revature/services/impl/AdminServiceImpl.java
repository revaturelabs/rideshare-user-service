package com.revature.services.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Admin;
import com.revature.repositories.AdminRepository;
import com.revature.services.AdminService;

/**
 * AdminServiceImpl handles any additional services that need to be made before calling the
 * repository methods.
 * 
 * @author Adonis Cabreja
 *
 */

@Service
public class AdminServiceImpl implements AdminService {
	
	static Logger logger = Logger.getRootLogger();
	
	@Autowired
	private AdminRepository ar;
	
	/**
	 * Calls AdminRepository's findAll method found in the JpaRepository.
	 * 
	 * @return A list of all the admins.
	 */
	
	@Override
	public List<Admin> getAdmins() {
		return ar.findAll();
	}

	/**
	 * Calls AdminRepository's getOne method found in the JpaRepository.
	 * 
	 * @param id represents the admin's id.
	 * @return An admin that matches the id.
	 */
	
	@Override
	public Admin getAdminById(int id) {
		if(id < 1) {
			logger.warn("User ID should not be less than one");
			return null;
		}
		else {
		return ar.findById(id).get();
		}
	}

	/**
	 * Calls AdminRepository's save method found in the JpaRepository.
	 * 
	 * @param admin represents the new Admin object being sent.
	 * @return The newly created object.
	 */
	
	@Override
	public Admin createAdmin(Admin admin) {
		if(admin.getAdminId() < 1)
		{
			logger.warn("Admin ID can't be less than 1");
			return null;
		} else if(admin.getUserName().equals("")) {
			logger.warn("User name can't be empty");
			return null;
			
		}
		return ar.save(admin);
	}

	/**
	 * Calls AdminRepository's save method found in the JpaRepository.
	 * 
	 * @param admin represents the updated Admin object being sent.
	 * @return The newly updated object.
	 */
	
	@Override
	public Admin updateAdmin(Admin admin) {
		if(admin.getAdminId() < 1 ) {
			logger.warn("Admin ID can't be less than 1");
			return null;
		}
		return ar.save(admin);
	}
	
	/**
	 * Calls AdminRepository's deleteById method found in the JpaRepository.
	 * 
	 * @param id represents admin's id.
	 * @return A string that says which admin was deleted.
	 */
	
	@Override
	public String deleteAdminById(int id) {
		if(id < 1) {
			logger.warn("Admin ID can't be less than 1 ");
			return null;
		}
		ar.deleteById(id);
		return "Admin with id: " + id + " was deleted.";
	}

}
