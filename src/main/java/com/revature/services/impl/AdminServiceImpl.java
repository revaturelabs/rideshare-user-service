package com.revature.services.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
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
	
	private static Logger logger = Logger.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private AdminRepository ar;
	
	/**
	 * Calls AdminRepository's findAll method found in the JpaRepository.
	 * 
	 * @return A list of all the admins.
	 */
	
	@Override
	public List<Admin> getAdmins() {
		logger.trace("Get all admins ");
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
		
		logger.trace("Get admin with ID number: " + id);
		return ar.findById(id).get();
		
	}

	/**
	 * Calls AdminRepository's save method found in the JpaRepository.
	 * 
	 * @param admin represents the new Admin object being sent.
	 * @return The newly created object.
	 */
	
	@Override
	public Admin createAdmin(Admin admin) {
		logger.info("Admin created ");
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
		logger.info("Admin updated");
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
		logger.info("Admin deleted");
		ar.deleteById(id);
		return "Admin with id: " + id + " was deleted.";
	}

}
