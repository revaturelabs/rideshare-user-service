package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Admin;
import com.revature.services.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * AdminController takes care of handling our requests to /admins.
 * It provides methods that can perform tasks like all admins, admin by id, add admin, update admin, and
 * delete admin by id.
 * 
 * @author Adonis Cabreja
 *
 */

@RestController
@RequestMapping("/admins")
@CrossOrigin
@Tag(name = "Admin", description = "Admin Controller")
public class AdminController {
	
	@Autowired
	private AdminService as;
	

	@Operation(summary = "Return list of admins", description="Returns all admins", tags={"Admin"})
	@GetMapping(produces = "application/json")
	public List<Admin> getAdmins() {
		
		return as.getAdmins();
	}
	
	@Operation(summary = "Return specified admin", description="Returns admin by id", tags={"Admin"})
	@GetMapping(value = "/{id}", produces = "application/json")
	public Admin getAdminById(@Parameter(description="Id of Admin", required=true) @PathVariable("id")int id) {
		
		return as.getAdminById(id);
	}

	@Operation(summary = "Create admin", description="Adds a new admin", tags={"Admin"})
	@PostMapping(produces = "application/json")
	public ResponseEntity<Admin> createAdmin(@Parameter(description="Admin to create", required=true)@Valid @RequestBody(required = true) Admin admin) {
		
		return new ResponseEntity<>(as.createAdmin(admin), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Update specified admin", description="Updates admin by id", tags={"Admin"})
	@PutMapping(value = "/{id}", produces = "application/json")
	public Admin updateAdmin(@Parameter(description="Admin to update", required=true) @Valid @RequestBody(required = true) Admin admin) {
		
		return as.updateAdmin(admin);
	}
	
	
	@Operation(summary = "Delete specified admin", description="Deletes admin by id", tags={"Admin"})
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public String deleteAdmin(@Parameter(description="Id of Admin", required=true) @PathVariable("id")int id) {
		
		return as.deleteAdminById(id);
	}
}
