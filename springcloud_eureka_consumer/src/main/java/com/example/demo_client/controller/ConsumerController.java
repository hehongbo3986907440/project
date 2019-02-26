package com.example.demo_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_client.service.IRemoteService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	
	@Autowired
	private IRemoteService remoteService;
	
	@RequestMapping("service")
	public String publish(String mes){
		String result = remoteService.getMess(mes);
		System.out.println(result);
		return result;
	}
}
