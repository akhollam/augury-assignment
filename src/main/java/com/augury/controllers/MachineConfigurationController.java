package com.augury.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.augury.service.MachineConfigurationService;

@RestController
public class MachineConfigurationController {

	private static Logger LOGGER = LoggerFactory.getLogger(MachineConfigurationController.class);
	
	@Autowired
	private MachineConfigurationService machineConfigurationService;

	@PostMapping("/machine-conf/{machineId}")
	public ResponseEntity<Void> machineFeeds(@PathVariable String machineId,
			@RequestBody Object machineConfiguration) {
		LOGGER.info("Machcine id received is {}, machineConfiguration - {}", machineId, machineConfiguration);
		machineConfigurationService.processMachineConfiguration(machineConfiguration);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/machine-conf")
	public ResponseEntity<Map<String, Object>> allMachineConf() {
		LOGGER.info("Machcine id received is {}, machineConfiguration - {}");
		return ResponseEntity.ok(machineConfigurationService.fetchAllMachineConfigurations());
	}

}
