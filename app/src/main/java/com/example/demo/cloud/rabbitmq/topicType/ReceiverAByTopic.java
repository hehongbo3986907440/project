package com.example.demo.cloud.rabbitmq.topicType;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(bindings=@QueueBinding(value=@Queue(value="${mq.config.queue.topic.info}",autoDelete="true"),exchange=@Exchange(type=ExchangeTypes.TOPIC,value="${mq.config.topic.exchange}"),key="*.log.info"))
public class ReceiverAByTopic {
	@RabbitHandler
	public void process(String mes){
		System.out.println("info -------topic :"+mes);
	}
}
