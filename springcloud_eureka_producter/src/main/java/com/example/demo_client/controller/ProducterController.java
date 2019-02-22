package com.example.demo_client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producter")
public class ProducterController {
	@RequestMapping("service")
	public String publish(String mes) {
		System.err.println(mes);
		return "return result :" + mes;
	}
}
