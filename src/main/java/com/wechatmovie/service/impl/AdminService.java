package com.wechatmovie.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatmovie.Exception.ServiceException;
import com.wechatmovie.controller.dto.LoginDTO;
import com.wechatmovie.controller.request.BaseRequest;
import com.wechatmovie.controller.request.LoginRequest;
import com.wechatmovie.entity.Admin;
import com.wechatmovie.mapper.AdminMapper;
import com.wechatmovie.service.IAdminService;
import com.wechatmovie.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service    // 注释,标注为spring的组件,才能被调用
public class AdminService implements IAdminService {
    // 4. 实现类, 调用mapper接口

    @Autowired
    AdminMapper adminMapper;

    // 用户列表
    @Override
    public List<Admin> listAdmins() {
        return adminMapper.listAdmins();
    }

    // 分页
    @Override
    public PageInfo<Admin> adminsPage(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Admin> admins = adminMapper.listByCondition(baseRequest);// 按条件查找
        return new PageInfo<>(admins);
    }

    // 新增用户
    @Override
    public void addAdmin(Admin admin) {
        try {
            adminMapper.addAdmin(admin);
        } catch(DuplicateKeyException e) {
            log.error("数据插入失败, adminName: {}", admin.getAdminName());
            throw new ServiceException("管理员账号重复");

        }
    }

    // 查询当前id的用户信息
    @Override
    public Admin getById(Integer adminId) {
        return adminMapper.getById(adminId);
    }

    // 修改信息后更新
    @Override
    public void updateById(Admin admin) {
        adminMapper.updateById(admin);
    }

    // 通过id删除
    @Override
    public void deleteById(Integer adminId) {
        adminMapper.deleteById(adminId);
    }

    // 登录
    @Override
    public LoginDTO login(LoginRequest loginRequest) {
        adminMapper.getByAdminName(loginRequest.getAdminName());
        // Admin admin = adminMapper.getByAdminNameAndPassword(loginRequest);
        Admin admin = null;
        try {
            admin = adminMapper.getByAdminName(loginRequest.getAdminName());
        } catch (Exception e) {
            log.error("根据用户名{} 查询错误", loginRequest.getAdminName());
            throw new ServiceException("用户名错误");
        }
        // 判断密码是否合法
        String adminPassword = loginRequest.getPassword();
        if (!adminPassword.equals(admin.getPassword())) {
            throw new ServiceException("用户名或密码错误");
        }
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(admin, loginDTO);

        // 生成token
        String token = TokenUtils.genToken(String.valueOf(admin.getAdminId()), admin.getPassword());
        loginDTO.setToken(token);


        return loginDTO;
    }


}
