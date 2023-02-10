package com.wechatmovie.mapper;


import com.wechatmovie.controller.request.UserPageRequest;
import com.wechatmovie.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper     // 使用Mapper注解,将这个注册为spring的一个bean
public interface UserMapper {

    // 2. mapper接口,提供数据库调用的方法

    // 查询所有用户列表
    //  @Select("select * from usertable")
    List<User> listUsers();

    // 分页
    List<User> listByCondition(UserPageRequest userPageRequest);

    // 新增用户
    void addUser(User user);

    // 通过Id查询
    User getByUserId(Integer userId);

    // 通过Id删除
    void updateUserById(User user);

    void deleteUserById(Integer userId);
}


















