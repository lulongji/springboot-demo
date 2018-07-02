package com.example.demo.web;

import com.example.demo.service.UserService;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }
}
