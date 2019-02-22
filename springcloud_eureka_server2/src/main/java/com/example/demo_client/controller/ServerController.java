package com.example.demo_client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/server")
public class ServerController {
	
	@RequestMapping("/invoke")
	public void invoke(){
		System.out.println("服务调用成功");
	}
}
