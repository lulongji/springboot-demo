package com.example.demo.service.impl;

import com.example.demo.service.TestBootService;
import org.springframework.stereotype.Service;


/**
 * @Description:
 * @Author: lulongji
 */
@Service
public class TestBootServiceImpl implements TestBootService {

    @Override
    public String test() throws Exception {
        return "Hello  test！ ";
    }
}
