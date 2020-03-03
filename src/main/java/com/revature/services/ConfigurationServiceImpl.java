package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revature.entities.Configuration;
import com.revature.repositories.ConfigurationRepo;

@Component
@Service
public class ConfigurationServiceImpl implements ConfigurationService {

	@Autowired
	ConfigurationRepo cr;
	
	@Override
	public String getConfigurationByLabel(String label) {
		Configuration c = cr.findByLabel(label);
		return c.getValue();
	}

}
