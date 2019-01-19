package com.albert.web;

import com.albert.pojo.User;
import com.albert.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @RequestMapping("/{id}")
    public User queryUser(@PathVariable(value = "id") Long id) {
        return userService.queryUserById(id);
    }
}
