package com.example.demo.cloud.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
	@Bean
	public Queue getQueue(){
		return new Queue("test_queue");
	}
}
