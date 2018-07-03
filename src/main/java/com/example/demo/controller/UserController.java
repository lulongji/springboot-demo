package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lulongji
 */
@RequestMapping("/user")
@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService testBootService;

    /**
     * 添加
     *
     * @return
     */
    @RequestMapping("/addUser")
    public String test() {
        String test = "";
        try {
            User user = new User();
            user.setId("1111");
            user.setUsername("张三");
            user.setPassword("1");
            user.setAge(10);
            testBootService.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }
}
