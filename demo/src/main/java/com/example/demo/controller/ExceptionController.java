package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/exception")
public class ExceptionController {
	@RequestMapping("/null")
	public String nu(){
		String a= null;
		a = a.toLowerCase();
		return "index";
	}
	
	@RequestMapping("/indexOut")
	public String indexOut(){
		String[] strs = {};
		return strs[2];
	}
	
	@RequestMapping("/ar")
	public void ar(){
		int a = 10;
		a = a/0;
	}
}
