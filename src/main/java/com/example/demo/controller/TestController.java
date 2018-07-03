package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: Hello World
 * @Author: lulongji
 */
@RestController
@EnableAutoConfiguration
public class TestController {


    @Value("${test}")
    private String path;

    @RequestMapping("/")
    public String test() {
        return path;
    }

}
