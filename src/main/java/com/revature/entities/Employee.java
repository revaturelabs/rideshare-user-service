package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	@Schema ( example = "1")
	private int employee_id;
	
	@Column(name = "email")
	@Schema( example = "example@gmail.com")
	private String email;
	
	@Column(name = "first_name")
	@Schema( example = "Michelle")
	private String first_name;
	
	@Column (name = "last_name")
	@Schema (example = "Obama")
	private String last_name;
	
	@Column (name = "phone_number")
	@Schema (example = "555-555-5555")
	private String phone_number;
	
	@Column (name = "user_name")
	@Schema (example = "asdf")
	private String username;
	
	@Column (name = "password")
	@Schema (example = "password")
	private String password;
	
	@Column (name = "user_address")
	@Schema (example = "92 Chateau Royal Court, Morgantown, WV 26505")
	private String user_address;
	
	@Column (name = "is_accepting_rides")
	@Schema (example = "true")
	private boolean is_accepting_rides;
	
	@Column (name = "is_active")
	@Schema (example = "true")
	private boolean is_active;
	
	@Column (name = "is_driver")
	@Schema (example = "true")
	private boolean isDriver;
	
	@Column (name = "is_manager")
	@Schema (example = "true")
	private boolean is_manager;
	
	@JoinColumn (name = "office_id")
	@Schema (implementation = Office.class)
	@ManyToOne
	private Office office;

	public Employee() {
		super();
	}

	public Employee(int employee_id, String email, String first_name, String last_name, String phone_number,
			String username, String password, String user_address, boolean is_accepting_rides, boolean is_active,
			boolean isDriver, boolean is_manager, Office office) {
		super();
		this.employee_id = employee_id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.username = username;
		this.password = password;
		this.user_address = user_address;
		this.is_accepting_rides = is_accepting_rides;
		this.is_active = is_active;
		this.isDriver = isDriver;
		this.is_manager = is_manager;
		this.office = office;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String user_name) {
		this.username = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public boolean isIs_accepting_rides() {
		return is_accepting_rides;
	}

	public void setIs_accepting_rides(boolean is_accepting_rides) {
		this.is_accepting_rides = is_accepting_rides;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public boolean isIsDriver() {
		return isDriver;
	}

	public void setIsDriver(boolean isDriver) {
		this.isDriver = isDriver;
	}

	public boolean isIs_manager() {
		return is_manager;
	}

	public void setIs_manager(boolean is_manager) {
		this.is_manager = is_manager;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", email=" + email + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", phone_number=" + phone_number + ", username=" + username
				+ ", password=" + password + ", user_address=" + user_address + ", is_accepting_rides="
				+ is_accepting_rides + ", is_active=" + is_active + ", isDriver=" + isDriver + ", is_manager="
				+ is_manager + ", office=" + office + "]";
	}
	
	
	
}
