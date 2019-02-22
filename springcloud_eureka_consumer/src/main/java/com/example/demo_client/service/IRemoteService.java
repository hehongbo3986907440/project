package com.example.demo_client.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="springcloud-eureka-producter")
public interface IRemoteService {
	@RequestMapping(value="/producter/service")
	public String getMess(@RequestParam(value="mes")String mes);
}
