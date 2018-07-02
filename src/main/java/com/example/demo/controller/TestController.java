package com.example.demo.controller;


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

    @RequestMapping("/")
    public String test() {
        return "Hello world";
    }
}
