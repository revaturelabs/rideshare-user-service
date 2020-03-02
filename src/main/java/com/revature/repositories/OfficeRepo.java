package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.entities.Office;

@Repository
public interface OfficeRepo extends CrudRepository<Office,Integer> {

}
