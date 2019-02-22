package com.example.demo.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobA {
	@Scheduled(cron="10 30 * * * ?")
	public void excute(){
		System.out.print("执行成功");
	}
}
