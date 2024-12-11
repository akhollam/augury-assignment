package com.augury.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.augury.service.MachineFeedService;

@RestController
public class MachineFeedsController {

	private static Logger LOGGER = LoggerFactory.getLogger(MachineFeedsController.class);

	@Autowired
	private MachineFeedService machineFeedService;

	@GetMapping("/machine-feeds/{machineId}")
	public ResponseEntity<Object> machineFeeds(@PathVariable String machineId,
			@RequestParam(required = true) String fromDateTime) {
		LOGGER.info("Machcine id received is {}, machineFeedsFrom - {}", machineId, fromDateTime);
		Object machineFeeds = machineFeedService.fetchMachineFeeds(machineId, fromDateTime);
		return ResponseEntity.ok(machineFeeds);
	}

}
