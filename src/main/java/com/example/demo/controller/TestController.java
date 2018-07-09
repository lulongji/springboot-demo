package com.example.demo.controller;


import com.llj.base.page.Result;
import com.llj.base.utils.cache.redis.springTemplate.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description: Hello World
 * @Author: lulongji
 */
@Controller
@EnableAutoConfiguration
public class TestController {


    @Value("${test}")
    private String path;

    @RequestMapping("/")
    @ResponseBody
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

    @RequestMapping("/test1")
    public String test1(Map<String, Object> map) {
        map.put("nameKey", path);
        return "test";
    }

    @RequestMapping("/test2")
    public ModelAndView testView() {
        ModelAndView mv = new ModelAndView("test");
        mv.addObject("nameKey", path);
        mv.addObject("11111", "1111");
        mv.addObject("11111", "111111");
        mv.addObject("sssss", "sssssss");
        mv.addObject("ssscccc", "sssssss");
        return mv;
    }

    @RequestMapping("/test3")
    public ModelAndView test3() {
        Map<String, String> map = new HashMap();
        map.put("aaaa", "aaaaa");
        map.put("bbbb", "bbbbb");
        map.put("cccc", "你俩的禄口机场斯蒂芬路上慢点");
        map.put("nameKey", path);
        return new ModelAndView("test", map);
    }



}
