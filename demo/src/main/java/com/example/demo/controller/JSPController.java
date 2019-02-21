package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/jsp")
public class JSPController {
	@RequestMapping("/index")
	public String index(HttpServletRequest req, HttpServletResponse res) {
		return "/jsp/firstJsp";
	}
	
	@RequestMapping("/second")
	public ModelAndView second(HttpServletRequest req, HttpServletResponse res){
		ModelAndView model = new ModelAndView();
		model.setViewName("/jsp/firstJsp");
		return model;
	}
}
