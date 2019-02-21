package com.example.demo_client.rabbitMq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo_client.rabbitmq.SenderByTopic;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQRTest {
	@Autowired
	private SenderByTopic sender;
	@Test
	public void test1(){
		sender.send("test rabbitMQ publisher");
	}
}
