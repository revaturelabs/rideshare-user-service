package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.entities.Configuration;

@Repository
public interface ConfigurationRepo extends CrudRepository<Configuration,Integer>  {

	public Configuration findByLabel(String label);

}
