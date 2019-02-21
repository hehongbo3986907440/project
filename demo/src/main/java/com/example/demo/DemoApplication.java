package com.example.demo;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.example.demo.filter.SecondFilter;
import com.example.demo.servlet.SecondServlet;


@SpringBootApplication
@ServletComponentScan
@EnableCaching
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public ServletRegistrationBean getServletRegistrationBean(){
		ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
		bean.addUrlMappings("/system/secondServlet");
		return bean;
	}
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean(){
		FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
		bean.addUrlPatterns("/system/*");
		return bean;
	}
	
	//全局异常处理方式三
	@Bean
	public SimpleMappingExceptionResolver getMappingExceptionResolver(){
		SimpleMappingExceptionResolver s = new SimpleMappingExceptionResolver();
		Properties map = new Properties();
		
		map.put("java.lang.ArithmeticException", "error1");
		
		s.setExceptionMappings(map);
		return s;
	}
}

