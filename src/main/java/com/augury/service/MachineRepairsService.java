package com.augury.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.augury.configs.RabbitMQConfig;

@Service
public class MachineRepairsService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(MachineRepairsService.class);
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@RabbitListener(queues = RabbitMQConfig.REPAIR_QUEUE)
	public void processMachineReparis(String repair) {

		// TODO: persist the repairs into database
		
		LOGGER.info("streamFeed called with - {}", repair);
		
		// TODO: extract the machine id from the repair and form the dynamic topic 
		// assumed the extracted machine id is 123456789
		
		String topicName = "/topic/feed/" + "123456789";
		messagingTemplate.convertAndSend(topicName, repair);
		
	}

}
