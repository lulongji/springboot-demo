package com.example.demo.dao;

import com.example.demo.domain.User;

import java.util.List;

/**
 * @Description:
 * @Author: lulongji
 */
public interface UserDao {

    void add(User user) throws Exception;

    void update(User user) throws Exception;

    void delete(User user) throws Exception;

    User get(User user) throws Exception;

    List<User> getUserList(User user) throws Exception;

}
