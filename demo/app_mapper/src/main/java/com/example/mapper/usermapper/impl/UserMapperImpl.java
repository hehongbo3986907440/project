package com.example.mapper.usermapper.impl;

import com.example.entity.user.UserEntity;
import com.example.mapper.usermapper.IUserMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository("userMapper")
public class UserMapperImpl implements IUserMapper {
    @Override
    public List<UserEntity> getUsers() {
        List<UserEntity> data = new ArrayList<>();
        UserEntity a = new UserEntity();
        a.setName("a");
        a.setAge(10);
        data.add(a);
        return data;
    }
}
