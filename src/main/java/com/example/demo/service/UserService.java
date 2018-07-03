package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

/**
 * 用户数据接口
 *
 * @Description:
 * @Author: lulongji
 */
public interface UserService {

    /**
     * 添加
     *
     * @param user
     * @throws Exception
     */
    void addUser(User user) throws Exception;

    /**
     * 修改（参数：username）
     *
     * @param user
     * @throws Exception
     */
    void updateUser(User user) throws Exception;

    /**
     * 删除（参数：username）
     *
     * @param user
     * @throws Exception
     */
    void deleteUser(User user) throws Exception;

    /**
     * 查询（单条数据 参数：username ，password）
     *
     * @param user
     * @return
     * @throws Exception
     */
    User getUser(User user) throws Exception;


    /**
     * 查询（单条数据 参数：id）
     *
     * @param user
     * @return
     * @throws Exception
     */
    User getUserById(User user) throws Exception;

    /**
     * 查询（所有数据 参数：选填）
     *
     * @param user
     * @return
     * @throws Exception
     */
    List<User> getUserList(User user) throws Exception;

}
