package com.revature.services;

import java.util.List;

import com.revature.entities.Car;

public interface CarService {

	public List<Car> getCars();
	public Car getCarById(int id);
	public List<Car> getCarByEmployeeId(int employeeId);
	public Car addCar(Car car);
	public Car updateCar(Car car);
	public boolean deleteCar(Car car);
}
