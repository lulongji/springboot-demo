package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

/**
 * @Description:
 * @Author: lulongji
 */
public interface UserService {

    void add(User user) throws Exception;

    void update(User user) throws Exception;

    void delete(User user) throws Exception;

    User get(User user) throws Exception;

    List<User> getUserList(User user) throws Exception;

}
