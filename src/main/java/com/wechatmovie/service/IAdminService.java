package com.wechatmovie.service;

import com.github.pagehelper.PageInfo;
import com.wechatmovie.controller.dto.LoginDTO;
import com.wechatmovie.controller.request.BaseRequest;
import com.wechatmovie.controller.request.LoginRequest;
import com.wechatmovie.entity.Admin;

import java.util.List;

public interface IAdminService {
    // 3. 业务处理层, 操作数据库, 先写个接口

    // 查询所有的用户信息
    List<Admin> listAdmins();

    // 分页
    PageInfo<Admin> adminsPage(BaseRequest baseRequest);

    // 添加新用户
    void addAdmin(Admin admin);

    // 通过Id查询到详细信息
    Admin getById(Integer adminId);

    // 修改信息后更新
    void updateById(Admin admin);

    // 删除
    void deleteById(Integer adminId);

    // 登录
    LoginDTO login(LoginRequest loginRequest);
}
