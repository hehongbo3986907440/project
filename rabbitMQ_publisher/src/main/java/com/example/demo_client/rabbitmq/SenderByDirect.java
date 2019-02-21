package com.example.demo_client.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SenderByDirect {
	@Autowired
	private AmqpTemplate rabbitMqTemplate;

	@Value("${mq.config.exchange}")
	private String exchange;
	@Value("${mq.config.queue.error.routing.key}")
	private String routingKey;
	
	@Value("${mq.config.queue.info.routing.key}")
	private String routingKeyOther;
	
	public void send(String mes){
		rabbitMqTemplate.convertAndSend(exchange, routingKey, mes);
	}
	
	public void send2(String mes){
		rabbitMqTemplate.convertAndSend(exchange, routingKeyOther, mes);
	}
}
