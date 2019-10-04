package com.cpy.springbootdemo.service;

import com.cpy.springbootdemo.entity.User;
import com.cpy.springbootdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User Sel(int id){
        return userMapper.Sel(id);
    }
    public User login(String userName, String passWord) {
        return userMapper.login(userName,passWord);
    }

    public int register(User user) {
        return userMapper.register(user);
    }
}
