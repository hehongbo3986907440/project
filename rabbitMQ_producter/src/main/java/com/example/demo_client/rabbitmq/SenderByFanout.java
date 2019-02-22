package com.example.demo_client.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SenderByFanout {
	@Autowired
	private AmqpTemplate rabbitMqTemplate;

	@Value("${mq.config.fanout.exchange}")
	private String exchange;
	
	public void send(String mes){
		rabbitMqTemplate.convertAndSend(exchange, "", mes);
	}
	
}
