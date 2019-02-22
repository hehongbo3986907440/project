package com.example.demo.common;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=java.lang.NullPointerException.class)
	public void nullPointHandler(Exception e){
		System.out.print("处理全局空指针异常");
	}
	@ExceptionHandler(value=java.lang.IndexOutOfBoundsException.class)
	public void indexOutOfHandler(){
		System.out.print("处理数组下标越界异常");
	}
}
