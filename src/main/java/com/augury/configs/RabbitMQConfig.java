package com.augury.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	public static final String REPAIR_QUEUE = "repairQueue";
	public static final String SESSION_QUEUE = "sessionQueue";
	public static final String EXCHANGE = "machineExchange";
	public static final String MACHINE_FEEDS_QUEUE = "feedsQueue";

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
	}

	@Bean
	public Queue repairQueue() {
		return new Queue(REPAIR_QUEUE);
	}

	@Bean
	public Queue sessionQueue() {
		return new Queue(SESSION_QUEUE);
	}

	@Bean
	public Queue feedsQueue() {
		return new Queue(MACHINE_FEEDS_QUEUE);
	}

	@Bean
	public Binding repairBinding(Queue repairQueue, TopicExchange exchange) {
		return BindingBuilder.bind(repairQueue).to(exchange).with("repair.#");
	}

	@Bean
	public Binding sessionBinding(Queue sessionQueue, TopicExchange exchange) {
		return BindingBuilder.bind(sessionQueue).to(exchange).with("session.#");
	}

	@Bean
	public Binding feedsBinding(Queue feedsQueue, TopicExchange exchange) {
		return BindingBuilder.bind(feedsQueue).to(exchange).with("feed.#");
	}
}
