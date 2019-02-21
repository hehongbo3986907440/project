package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.Users;

public interface IMybaitsService {
	List<Users> getUsers();
	void saveUser(Users u);
}
