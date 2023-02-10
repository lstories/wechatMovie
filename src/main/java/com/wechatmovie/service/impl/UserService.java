package com.wechatmovie.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatmovie.controller.request.UserPageRequest;
import com.wechatmovie.entity.User;
import com.wechatmovie.mapper.UserMapper;
import com.wechatmovie.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service    // 注释,标注为spring的组件,才能被调用
public class UserService implements IUserService {
    // 4. 实现类, 调用mapper接口

    @Autowired
    UserMapper userMapper;

    // 用户列表
    @Override
    public List<User> listUsers() {
        return userMapper.listUsers();
    }

    // 分页
    @Override
    public Object usersPage(UserPageRequest userPageRequest) {
        PageHelper.startPage(userPageRequest.getPageNum(), userPageRequest.getPageSize());
        List<User> users = userMapper.listByCondition(userPageRequest);// 按条件查找
        return new PageInfo<>(users);
    }

    // 新增用户
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    // 查询当前id的用户信息
    @Override
    public User getByUserId(Integer userId) {
        return userMapper.getByUserId(userId);
    }

    // 修改信息后更新
    @Override
    public void updateUser(User user) {
        userMapper.updateUserById(user);
    }

    @Override
    public void deleteUserById(Integer userId) {
        userMapper.deleteUserById(userId);
    }


}
