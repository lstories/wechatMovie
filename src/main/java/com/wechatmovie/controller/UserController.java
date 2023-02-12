package com.wechatmovie.controller;


import com.wechatmovie.common.Result;
import com.wechatmovie.controller.request.UserPageRequest;
import com.wechatmovie.entity.User;
import com.wechatmovie.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired  // 注入
    IUserService userService;

    // 用户列表
    @GetMapping("/list")
    public Result listUsers() {
        List<User> users = userService.listUsers();
        return Result.success(users);
    }

    // 分页功能
    @GetMapping("/page")
    public Result usersPage(UserPageRequest userPageRequest) {
        return Result.success(userService.usersPage(userPageRequest));
    }

    // 新增用户
    @PostMapping("/adduser")
    public Result addUser(@RequestBody User user) {
        userService.addUser(user);
        return Result.success();
    }

    // 通过查userId 返回到页面对应的位置的数据
    @GetMapping("/{userId}")
    public Result getById(@PathVariable Integer userId) {
        User user = userService.getByUserId(userId);
        return Result.success(user);
    }

    // 更新修改后的用户信息
    @PutMapping("/update")
    public Result update(@RequestBody User user){
        userService.updateUser(user);
        return Result.success();
    }

    // 根据id删除用户
    @DeleteMapping("/delete/{userId}")
    public Result delete(@PathVariable Integer userId) {
        userService.deleteUserById(userId);
        return Result.success();
    }












}
