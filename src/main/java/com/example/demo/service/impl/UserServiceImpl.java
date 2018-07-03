package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void addUser(User user) throws Exception {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) throws Exception {
        userDao.deleteUser(user);
    }

    @Override
    public User getUser(User user) throws Exception {
        return userDao.getUser(user);
    }

    @Override
    public User getUserById(User user) throws Exception {
        return userDao.getUserById(user);
    }

    @Override
    public List<User> getUserList(User user) throws Exception {
        return userDao.getUserList(user);
    }
}
