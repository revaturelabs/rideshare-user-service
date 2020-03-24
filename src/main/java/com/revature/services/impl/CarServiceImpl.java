package com.revature.services.impl;

import java.util.List;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Car;
import com.revature.repositories.CarRepository;
import com.revature.services.CarService;

/**
 * CarServiceImpl handles any additional services that need to be made before calling the
 * repository methods.
 * 
 * @author Adonis Cabreja
 *
 */

@Service
public class CarServiceImpl implements CarService {
	
	private static Logger logger = Logger.getLogger(CarServiceImpl.class);
	@Autowired
	private CarRepository cr;
	
	/**
	 * Calls CarRepository's findAll method found in the JpaRepository.
	 * 
	 * @return A list of all the cars.
	 */
	
	@Override
	public List<Car> getCars() {
		logger.trace("finding all cars");
		return cr.findAll();
	}

	/**
	 * Calls CarRepository's getOne method found in the JpaRepository.
	 * 
	 * @param id represents the car's id.
	 * @return A car that matches the car's id.
	 */
	
	@Override
	public Car getCarById(int id) {
		logger.trace("Updated car by id");
		return cr.findById(id).get();
	}

	/**
	 * Calls CarRepository's custom query method getCarByUserId.
	 * 
	 * @param userId represents the user's id.
	 * @return A car that matches the user's id.
	 */
	
	@Override
	public Car getCarByUserId(int userId) {
		logger.trace("finding car by user id");
		return cr.getCarByUserId(userId);
	}
	
	/**
	 * Calls CarRepository's save method found in the JpaRepository.
	 * 
	 * @param car represents the new Car object being sent.
	 * @return The newly created object.
	 */
	
	@Override
	public Car addCar(Car car) {
		logger.info("added car");
		return cr.save(car);
	}

	/**
	 * Calls CarRepository's save method found in the JpaRepository.
	 * 
	 * @param car represents the updated Car object being sent.
	 * @return The newly updated object.
	 */
	
	@Override
	public Car updateCar(Car car) {
		logger.info("Updated car");
		return cr.save(car);
	}

	/**
	 * Calls CarRepository's deleteById method found in the JpaRepository.
	 * 
	 * @param id represents the car's id.
	 * @return A string that says which car was deleted.
	 */
	
	@Override
	public String deleteCarById(int id) {
		cr.deleteById(id);
		
		logger.info("deleted car with " + id);
		return "Car with id: " + id + " was deleted.";
	}

}
