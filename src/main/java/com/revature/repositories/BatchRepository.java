package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.Batch;
import org.springframework.data.repository.query.Param;

/**
 * BatchRepository which extends the JpaRepository.
 * This repository handles our various queries.
 * 
 * @author Adonis Cabreja
 *
 */

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {
		
	public List<Batch> getBatchByBatchLocation(String batchLocation);
}
