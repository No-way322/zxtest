package com.zx.zxtest.controller;


import com.zx.zxtest.entity.User;
import com.zx.zxtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/allUser")
    public List<User> findAllUser(){
        List<User> userList = userService.findAllUser();
        return userList;
    }


    @GetMapping("/info")
    public String showInfo(){
        return "我是测试项目！！！";
    }

}
