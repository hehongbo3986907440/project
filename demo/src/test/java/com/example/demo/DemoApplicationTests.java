package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.service.IMybaitsService;
import com.example.demo.vo.Users;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	private IMybaitsService mybatisService;

	@Test
//	@Rollback(value=false)
	public void contextLoads() {
		List<Users> list = mybatisService.getUsers();
		System.err.println(list.size());
		
		Users u = new Users(1223345666,"testets",12);
		mybatisService.saveUser(u);
		
		List<Users> list2 = mybatisService.getUsers();
		System.err.println(list2.size());
	}

}

