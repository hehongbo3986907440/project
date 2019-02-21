package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.vo.Users;
@Mapper
public interface UserMapper {
	List<Users> getUsers();
	void insertUser(Users u);
}
