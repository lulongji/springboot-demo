package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {
    /**
     * 缓存的key
     */
    public static final String THING_ALL_KEY = "\"thing_all\"";
    /**
     * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
     */
    public static final String DEMO_CACHE_NAME = "users";

    @Autowired
    private UserDao userDao;


    @CacheEvict(value = DEMO_CACHE_NAME, key = THING_ALL_KEY)
    @Override
    public void addUser(User user) throws Exception {
        userDao.addUser(user);
    }

    @CachePut(value = DEMO_CACHE_NAME, key = "#user.getId()+'thing'")
    @CacheEvict(value = DEMO_CACHE_NAME, key = THING_ALL_KEY)
    @Override
    public void updateUser(User user) throws Exception {
        userDao.updateUser(user);
    }

    @CacheEvict(value = DEMO_CACHE_NAME)
    @Override
    public void deleteUser(User user) throws Exception {
        userDao.deleteUser(user);
    }

    @Override
    public User getUser(User user) throws Exception {
        return userDao.getUser(user);
    }

    @Cacheable(value = DEMO_CACHE_NAME, key = "#user.getId()+'thing'")
    @Override
    public User getUserById(User user) throws Exception {
        System.err.println("没有走缓存！" + user.getId());
        return userDao.getUserById(user);
    }

    @Cacheable(value = DEMO_CACHE_NAME, key = THING_ALL_KEY)
    @Override
    public List<User> getUserList(User user) throws Exception {
        return userDao.getUserList(user);
    }
}
