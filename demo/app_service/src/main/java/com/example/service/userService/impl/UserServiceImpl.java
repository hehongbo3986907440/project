package com.example.service.userService.impl;

import com.example.entity.user.UserEntity;
import com.example.mapper.usermapper.IUserMapper;
import com.example.service.userService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserMapper userMapper;
    @Override
    public List<UserEntity> getUsers() {
        return userMapper.getUsers();
    }
}
