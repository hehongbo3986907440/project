package com.example.demo.cloud.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Activer {
//	@RabbitListener(queues={"test_queue"})
	public void getMes(String mes){
		System.out.println(mes);
	}
}
