package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revature.entities.Car;
import com.revature.entities.Employee;
import com.revature.repositories.CarRepo;

@Component
@Service
public class CarServiceImpl implements CarService{

	@Autowired
	CarRepo cr;
	
	@Override
	public List<Car> getCars() {
		return (List<Car>) cr.findAll();
	}

	@Override
	public Car getCarById(int id) {
		return cr.findById(id);
	}

	@Override
	public List<Car> getCarByEmployeeId(int employeeId) {
		Employee e = new Employee();
		e.setEmployee_id(employeeId);
		return   cr.findByEmployee(e);
	}

	@Override
	public Car addCar(Car car) {
		return cr.save(car);
	}

	@Override
	public Car updateCar(Car car) {
		return cr.save(car);
	}

	@Override
	public boolean deleteCar(Car car) {
		cr.delete(car);
		return true;
	}

}
