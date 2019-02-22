package com.example.demo_client.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SenderByTopic {
	@Autowired
	private AmqpTemplate rabbitMqTemplate;

	@Value("${mq.config.topic.exchange}")
	private String exchange;
	
	public void send(String mes){
		rabbitMqTemplate.convertAndSend(exchange, "user.log.debug", "user.log.debug"+mes);
		rabbitMqTemplate.convertAndSend(exchange, "user.log.info", "user.log.info"+mes);
		rabbitMqTemplate.convertAndSend(exchange, "user.log.error", "user.log.error"+mes);
	}
	
	public void send2(String mes){
		rabbitMqTemplate.convertAndSend(exchange, "order.log.debug", "order.log.debug"+mes);
		rabbitMqTemplate.convertAndSend(exchange, "order.log.info", "order.log.info"+mes);
		rabbitMqTemplate.convertAndSend(exchange, "order.log.error", "order.log.error"+mes);
	}
	
	public void send3(String mes){
		rabbitMqTemplate.convertAndSend(exchange, "product.log.debug", "product.log.debug"+mes);
		rabbitMqTemplate.convertAndSend(exchange, "product.log.info", "product.log.info"+mes);
		rabbitMqTemplate.convertAndSend(exchange, "product.log.error", "product.log.error"+mes);
	}
}
