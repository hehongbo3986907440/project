package com.example.demo_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_client.service.IRemoteService;
import com.example.demo_client.service.IRemoteService2;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	
	@Autowired
	private IRemoteService remoteService;
	
	@Autowired
	private IRemoteService2 remoteService2;
	
	@RequestMapping("service")
	public String publish(String mes){
		String result = remoteService.getMess2();
		System.out.println(result);
		return result;
	}
	
}
