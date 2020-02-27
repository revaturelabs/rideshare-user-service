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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Batch;
import com.revature.services.BatchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * BatchController takes care of handling our requests to /batches.
 * It provides methods that can perform tasks like all batches, batch by number, batch by location, add batch,
 * update batch and delete batch by id.
 * 
 * @author Adonis Cabreja
 *
 */

@RestController
@RequestMapping("/batches")
@CrossOrigin
@Tag(name = "Batch", description = "Batch Controller")
public class BatchController {
	
	@Autowired
	private BatchService bs;
	
	@Operation(summary = "Return all batches",  description="Returns all batches", tags={"Batch"})
	@GetMapping(produces="application/json")
	public List<Batch> getBatches(@RequestParam(name="location",required=false)String location) {
		
		if (location != null) {
			
			return bs.getBatchByLocation(location);
		}
		
		return bs.getBatches();
	}
	
	@Operation(summary = "Return specified batch", description="Returns batch by number", tags={"Batch"})
	@GetMapping(value = "/{number}", produces = "application/json")
	public Batch getBatchByNumber(@Parameter(description="Id of batch", required = true)@PathVariable("number")int number) {
		
		return bs.getBatchByNumber(number);
	}
	
	@Operation(summary = "Create batch",description="Adds a new batch", tags={"Batch"})
	@PostMapping(produces="application/json")
	public ResponseEntity<Batch> addBatch(@Parameter(description="User to create", required=true) 
										@Valid @RequestBody(required = true) Batch batch) {
		
		return new ResponseEntity<>(bs.addBatch(batch), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Update specified batch", description="Updates batch", tags={"Batch"})
	@PutMapping(value = "/{number}", produces = "application/json")
	public Batch updateBatch(@Parameter(description="Batch to update", required=true) @Valid @RequestBody(required = true) Batch batch) {
		
		return bs.updateBatch(batch);
	}
	
	@Operation(summary = "Delete specified batch", description="Deletes batch by number", tags={"Batch"})
	@DeleteMapping(value = "/{number}", produces = "application/json")
	public String deleteBatchByNumber(@Parameter(description="Batch to delete", required=true) @PathVariable("number")int number) {
		
		return bs.deleteBatchByNumber(number);
	}
}
