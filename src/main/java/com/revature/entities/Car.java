package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	@Schema ( example = "1")
	private int car_id;
	
	@Column(name = "color")
	@Schema (example = "red")
	private String color;
	
	@Column (name = "make")
	@Schema(example = "Honda")
	private String make;
	
	@Column (name = "model")
	@Schema (example = "Accord")
	private String model;
	
	@Column (name = "available_seats")
	@Schema(example = "4")
	private int available_seats;
	
	@Column(name = "car_year")
	@Schema(example = "1998")
	private int car_year;
	
	@JoinColumn (name = "employee_id")
	@Schema (implementation = Employee.class)
	@ManyToOne
	private Employee employee;

	public Car() {
		super();
	}

	public Car(int car_id, String color, String make, String model, int available_seats, int car_year,
			Employee employee) {
		super();
		this.car_id = car_id;
		this.color = color;
		this.make = make;
		this.model = model;
		this.available_seats = available_seats;
		this.car_year = car_year;
		this.employee = employee;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getAvailable_seats() {
		return available_seats;
	}

	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}

	public int getCar_year() {
		return car_year;
	}

	public void setCar_year(int car_year) {
		this.car_year = car_year;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + available_seats;
		result = prime * result + car_id;
		result = prime * result + car_year;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
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
        if (!(o instanceof Car)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Car c = (Car) o; 
          
        // Compare the data members and return accordingly  
        return Double.compare(car_id, c.car_id) == 0
                && Double.compare(employee.getEmployee_id(), c.employee.getEmployee_id()) == 0; 
	}

	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", color=" + color + ", make=" + make + ", model=" + model
				+ ", available_seats=" + available_seats + ", car_year=" + car_year + ", employee=" + employee + "]";
	}
	
	
}
