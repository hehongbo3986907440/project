package com.example.mapper.usermapper;

import com.example.entity.user.UserEntity;

import java.util.List;

public interface IUserMapper {
    List<UserEntity> getUsers();
}
