package com.example.demo.cloud.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Sender {
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send(String mes){
		rabbitTemplate.convertAndSend("test_queue", mes);
	}
}
