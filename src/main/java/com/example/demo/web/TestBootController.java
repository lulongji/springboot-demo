package com.example.demo.web;

import com.example.demo.service.TestBootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lulongji
 */
@RequestMapping("/testboot")
@RestController
public class TestBootController {

    @Autowired
    private TestBootService testBootService;

    @RequestMapping("/test")
    public String test() {
        String test = "";
        try {
            test = testBootService.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }
}
