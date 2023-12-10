package com.ant_storage.ANT.Storage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant_storage.ANT.Storage.entity.Configuration;
import com.ant_storage.ANT.Storage.repository.ConfigurationRepository;

@Service
public class ConfigurationService {
	@Autowired
	private ConfigurationRepository configurationRepository;
	
	public List<Configuration> findConfiguration(){
		return configurationRepository.findAll();
	}
	
	public Configuration saveConfiguration(Configuration configuration) {
		return configurationRepository.save(configuration);
	}
	
	public void deleteConfiguration(Integer id) {
		configurationRepository.deleteById(id);
	}
	
	
}
