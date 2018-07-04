package com.example.demo.controller;


import com.llj.base.page.Result;
import com.llj.base.utils.cache.redis.springTemplate.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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

    @RequestMapping("/setRedis")
    public Result setRedis(String name) {
        Result result = Result.success();
        try {
            RedisTemplateUtil.set("springboot-test" + name, name, 5, TimeUnit.MINUTES);
        } catch (Exception e) {
            result = Result.failure();
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/getRedis")
    public Result getRedis(String name) {
        Result result = Result.success();
        try {
            Object obj = RedisTemplateUtil.get("springboot-test" + name);
            result.setResult(obj);
        } catch (Exception e) {
            result = Result.failure();
            e.printStackTrace();
        }
        return result;
    }

}
