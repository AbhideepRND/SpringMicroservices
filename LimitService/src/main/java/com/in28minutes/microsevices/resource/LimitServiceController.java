package com.in28minutes.microsevices.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microsevices.Configuration;
import com.in28minutes.microsevices.dto.LimitConfiguration;

@RestController
public class LimitServiceController {

	@Autowired
	private Configuration config;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		return new LimitConfiguration(config.getMinimum(), config.getMaximum());		
	}
}
