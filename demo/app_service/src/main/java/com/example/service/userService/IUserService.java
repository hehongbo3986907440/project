package com.example.service.userService;

import com.example.entity.user.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserEntity> getUsers();
}
