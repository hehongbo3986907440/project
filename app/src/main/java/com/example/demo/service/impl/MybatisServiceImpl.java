package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IMybaitsService;
import com.example.demo.vo.Users;
@Service("mybatisService")
public class MybatisServiceImpl implements IMybaitsService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Cacheable(value="users")
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		return userMapper.getUsers();
	}
	@CacheEvict(value="users",allEntries=true)
	public void saveUser(Users u){
		userMapper.insertUser(u);
	}
}
