package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description:
 * @Author: lulongji
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) throws Exception {
        userDao.add(user);
    }

    @Override
    public void update(User user) throws Exception {
        userDao.update(user);
    }

    @Override
    public void delete(User user) throws Exception {
        userDao.delete(user);
    }

    @Override
    public User get(User user) throws Exception {
        return userDao.get(user);
    }

    @Override
    public List<User> getUserList(User user) throws Exception {
        return userDao.getUserList(user);
    }
}
