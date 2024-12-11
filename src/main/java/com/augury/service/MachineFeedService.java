package com.augury.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MachineFeedService {

    public Object fetchMachineFeeds(String machineId, String fromDateTime) {
    	
    	// TODO: Fetch the machine, machine sessions and machine repairs 
    	// using their micro-services combine them into one object and return
    	
    	Map<String, Object> machineConfig = Map.of(
                "id", machineId,
                "created_at", "2024-12-09T12:00:00Z",
                "data", Map.of("name", "Machine A")
            );
    	
    	return machineConfig;
    }
}
