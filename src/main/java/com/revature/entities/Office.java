package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "office")
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="office_id")
	@Schema(example = "1")
	private int office_id;
	
	@Column(name = "office_address")
	@NotBlank
	@Schema(example = "496 High Street, Morgantown, WV 26505")
	private String office_address;

	public Office() {
		super();
	}

	public Office(int office_id, @NotBlank String office_address) {
		super();
		this.office_id = office_id;
		this.office_address = office_address;
	}

	public int getOffice_id() {
		return office_id;
	}

	public void setOffice_id(int office_id) {
		this.office_id = office_id;
	}

	public String getOffice_address() {
		return office_address;
	}

	public void setOffice_address(String office_address) {
		this.office_address = office_address;
	}

	@Override
	public String toString() {
		return "Office [office_id=" + office_id + ", office_address=" + office_address + "]";
	}
	
	
	
}
