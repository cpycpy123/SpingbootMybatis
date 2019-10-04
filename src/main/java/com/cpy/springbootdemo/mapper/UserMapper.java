package com.cpy.springbootdemo.mapper;

import com.cpy.springbootdemo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User Sel(int id);
    User login(String userName,String passWord);

    int register(User user);
}
