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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((office_address == null) ? 0 : office_address.hashCode());
		result = prime * result + office_id;
		return result;
	}

	@Override
	public boolean equals(Object o) {
		  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof Office)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Office off = (Office) o; 
          
        // Compare the data members and return accordingly  
        return Double.compare(office_id, off.office_id) == 0;
        
	}

	
	@Override
	public String toString() {
		return "Office [office_id=" + office_id + ", office_address=" + office_address + "]";
	}
	
	
	
}
