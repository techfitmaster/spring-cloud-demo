package com.albert.service.impl;

import com.albert.mapper.UserMapper;
import com.albert.pojo.User;
import com.albert.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    public User queryUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
