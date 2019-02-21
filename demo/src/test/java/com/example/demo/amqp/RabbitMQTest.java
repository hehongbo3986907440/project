package com.example.demo.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.cloud.rabbitmq.Sender;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitMQTest {
	@Autowired
	private Sender sender;
	@Test
	public void test1(){
		sender.send("send mes to queue by RabbitMQ");
	}
}
