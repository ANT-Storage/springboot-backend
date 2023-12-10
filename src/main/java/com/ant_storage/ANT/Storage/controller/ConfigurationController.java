package com.ant_storage.ANT.Storage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ant_storage.ANT.Storage.entity.Configuration;
import com.ant_storage.ANT.Storage.service.ConfigurationService;

@RestController
@RequestMapping("antstorage/v1/configurations")
public class ConfigurationController {
	@Autowired
	private ConfigurationService configurationService;
	
	@GetMapping List<Configuration> getConfiguration(){
		return configurationService.findConfiguration();
	}
	
	@PostMapping
	public Configuration createConfiguration(Configuration configuration) {
		return configurationService.saveConfiguration(configuration);
	}
	
	@DeleteMapping("/restore_app")
	public void restoreApp() {
		configurationService.restoreApp();
	}
	
	@DeleteMapping("/{id}")
	public void deleteConfiguration(@PathVariable Integer id) {
		configurationService.deleteConfiguration(id);
	}
	
}
