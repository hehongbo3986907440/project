package com.example.demo_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo_client.rabbitmq.SenderByDirect;
import com.example.demo_client.rabbitmq.SenderByFanout;
import com.example.demo_client.rabbitmq.SenderByTopic;

@Controller
@RequestMapping("/send")
public class SendMesController {
	@Autowired
	private SenderByDirect sender;
	
	@Autowired
	private SenderByTopic sender2;
	
	@Autowired
	private SenderByFanout sender3;
	
	@RequestMapping("/direct/txtMess")
	public void sendByDirect(String mes){
		sender.send(mes);
		sender.send2(mes);
	}
	
	@RequestMapping("/topic/txtMess")
	public void sendByTopic(String mes){
		sender2.send(mes);
		sender2.send2(mes);
		sender2.send3(mes);
	}
	
	@RequestMapping("/fanout/txtMess")
	public void sendByFanout(String mes){
		sender3.send(mes);
	}
}
