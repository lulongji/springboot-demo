package com.example.demo.dao;

import com.example.demo.domain.User;

import java.util.List;

/**
 * @Description:
 * @Author: lulongji
 */
public interface UserDao {

    void addUser(User user) throws Exception;

    void updateUser(User user) throws Exception;

    void deleteUser(User user) throws Exception;

    User getUser(User user) throws Exception;

    User getUserById(User user) throws Exception;

    List<User> getUserList(User user) throws Exception;

}
