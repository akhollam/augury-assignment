package com.augury.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MachineConfigurationService {

	public void processMachineConfiguration(Object machineConfiguration) {

		// TODO: use the CRUD of machine configuration database table and store the
		// machine configuration into database

	}

	public Map<String, Object> fetchAllMachineConfigurations() {

		// TODO: use the crud to fetch all machine config for UI

		Map<String, Object> machineConfig = Map.of("id", "asasaa-asd-asd-adsasd", "created_at", "2024-12-09T12:00:00Z",
				"data", Map.of("name", "Machine A"));

		return machineConfig;

	}

}
