package com.augury.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.augury.configs.RabbitMQConfig;

@RestController
public class MachineSessionsController {

	private static Logger LOGGER = LoggerFactory.getLogger(MachineSessionsController.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@PostMapping("/machine-feeds/session/{machineId}")
	public ResponseEntity<Void> machineSessionsFeeds(@PathVariable String machineId, @RequestBody Object session) {
		LOGGER.info("Machcine session received for id - {}, machineFeedsFrom - {}", machineId, session);
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "session.new", session.toString());
		return ResponseEntity.noContent().build();
	}

}
