package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.llj.base.page.Result;
import com.llj.base.uuid.UUIDGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户数据管理
 *
 * @Description:
 * @Author: lulongji
 */
@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService testBootService;

    /**
     * 添加测试数据
     *
     * @return
     */
    @RequestMapping("/addUser")
    public Result addUser(User user) {
        logger.info("添加测试数据，参数：" + user.toString());
        Result result = Result.success();
        try {
            UUIDGenerator uuidGenerator = new UUIDGenerator();
            user.setId(uuidGenerator.generate());
            testBootService.addUser(user);
        } catch (Exception e) {
            result = Result.failure();
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 修改测试数据
     *
     * @return
     */
    @RequestMapping("/modifyUser")
    public Result modifyUser(User user) {
        logger.info("修改测试数据，参数：" + user.toString());
        Result result = Result.success();
        try {
            testBootService.updateUser(user);
        } catch (Exception e) {
            result = Result.failure();
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除测试数据
     *
     * @return
     */
    @RequestMapping("/delUser")
    public Result delUser(User user) {
        logger.info("删除测试数据，参数：" + user.toString());
        Result result = Result.success();
        try {
            testBootService.deleteUser(user);
        } catch (Exception e) {
            result = Result.failure();
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据账户名查询
     *
     * @return
     */
    @RequestMapping("/getUserByUserName")
    public Result getUserByUserName(User user) {
        logger.info("根据账户名查询，参数：" + user.toString());
        Result result = Result.success();
        try {
            User userData = testBootService.getUser(user);
            result.setResult(userData);
        } catch (Exception e) {
            result = Result.failure();
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据Id查询
     *
     * @return
     */
    @RequestMapping("/getUserById")
    public Result getUserById(User user) {
        logger.info("根据Id查询，参数：" + user.toString());
        Result result = Result.success();
        try {
            User userData = testBootService.getUserById(user);
            result.setResult(userData);
        } catch (Exception e) {
            result = Result.failure();
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据条件查询所有数据
     *
     * @return
     */
    @RequestMapping("/getUserList")
    public Result getUserList(User user) {
        logger.info("根据条件查询所有数据，参数：" + user.toString());
        Result result = Result.success();
        try {
            List<User> userList = testBootService.getUserList(user);
            result.setResult(userList);
        } catch (Exception e) {
            result = Result.failure();
            e.printStackTrace();
        }
        return result;
    }
}
