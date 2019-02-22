package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileUpController {
	@RequestMapping("/upload")
	public void upLoadFile(HttpServletRequest req,HttpServletResponse res,MultipartFile file){
		System.out.println("文件名："+file.getName()+"文件大小："+file.getSize());
	}
}
