package com.revature.services.impl;



import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.beans.Batch;
import com.revature.repositories.BatchRepository;
import com.revature.services.BatchService;

/**
 * BatchServiceImpl handles any additional services that need to be made before calling the
 * repository methods.
 * 
 * @author Adonis Cabreja
 *
 */

@Service
public class BatchServiceImpl implements BatchService {
	
	Logger logger = Logger.getRootLogger();
	
	@Autowired
	private BatchRepository br;
	
	/**
	 * Calls BatchRepository's findAll method found in the JpaRepository.
	 * 
	 * @return A list of all the batches.
	 */
	
	@Override
	public List<Batch> getBatches() {
		logger.trace("Get all batches ");
		return br.findAll();
	}

	/**
	 * Calls BatchRepository's getOne method found in the JpaRepository.
	 * 
	 * @param number represents the batch number.
	 * @return A batch that matches the number.
	 */
	
	@Override
	public Batch getBatchByNumber(int id) {
		logger.trace("Get batch with ID number: " + id);
		return br.findById(id).get();
	}

	/**
	 * Calls BatchRepository's custom query method getBatchByLocation.
	 * 
	 * @param location represents the batch location.
	 * @return A list of batches by location.
	 */
	
	@Override
	public List<Batch> getBatchByLocation(String location) {
		logger.trace("Get batch with location: " + location);
		return br.getBatchByLocation(location);
	}
	
	/**
	 * Calls BatchRepository's save method found in the JpaRepository.
	 * 
	 * @param batch represents the new Batch object being sent.
	 * @return The newly created batch.
	 */
	
	@Override
	public Batch addBatch(Batch batch) {
		logger.info("Batch created ");
		return br.save(batch);
	}

	/**
	 * Calls BatchRepository's save method found in the JpaRepository.
	 * 
	 * @param batch represents the updated Batch object being sent.
	 * @return The newly updated batch.
	 */
	
	@Override
	public Batch updateBatch(Batch batch) {
		logger.info("Btach updated ");
		return br.save(batch);
	}

	/**
	 * Calls BatchRepository's deleteById method found in the JpaRepository.
	 * 
	 * @param number represents the batch number.
	 * @return A string that says which batch was deleted.
	 */
	
	@Override
	public String deleteBatchByNumber(int number) {
		logger.info("Batch delted ");
		br.deleteById(number);
		return "Batch number: " + number + " was deleted.";
	}

}
