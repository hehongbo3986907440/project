package com.example.demo.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.IMybaitsService;
import com.example.demo.vo.Users;
@Controller
@RequestMapping("/validate")
public class ValidateController {
	@Autowired
	private IMybaitsService mybatisService;
	@RequestMapping("/user")
	public String users(@Valid Users user,Model model){
		System.out.println(user);
		model.addAttribute("list", mybatisService.getUsers());
		// 跳转视图
		return "index";
	}
	
	@RequestMapping("/nu")
	public String nu(){
		String a= null;
		a = a.toLowerCase();
		return "index";
	}
	
	@RequestMapping("/ar")
	public String ar(){
		int a=10;
		a=a/0;
		return "index";
	}
	
	@ExceptionHandler(value=java.lang.NullPointerException.class)
	public void nullExHander(Exception e){
		System.out.println(e.getMessage());
	}
	@ExceptionHandler(value={java.lang.ArithmeticException.class})
	public void ArithmeticExceptionHandler(Exception e){
		System.out.println(e.getMessage());
	}
}
