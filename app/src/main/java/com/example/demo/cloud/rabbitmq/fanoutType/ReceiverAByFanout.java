package com.example.demo.cloud.rabbitmq.fanoutType;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings=@QueueBinding(value=@Queue(value="${mq.config.queue.fanout.sms}",autoDelete="true"),exchange=@Exchange(type=ExchangeTypes.FANOUT,value="${mq.config.fanout.exchange}")))
public class ReceiverAByFanout {
	@RabbitHandler
	public void process(String mes){
		System.out.println("sms -------fanout :"+mes);
	}
}
