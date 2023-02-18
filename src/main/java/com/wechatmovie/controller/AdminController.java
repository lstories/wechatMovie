package com.wechatmovie.controller;


import com.wechatmovie.common.Result;
import com.wechatmovie.controller.dto.LoginDTO;
import com.wechatmovie.controller.request.AdminPageRequest;
import com.wechatmovie.controller.request.LoginRequest;
import com.wechatmovie.entity.Admin;
import com.wechatmovie.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
    // 5. controller层实现将数据传递给前端浏览器
    // 对外暴露api

    @Autowired  // 注入
    IAdminService adminService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest) {
        LoginDTO loginDTO = adminService.login(loginRequest);
        return Result.success(loginDTO);
    }

    // 列表
    @GetMapping("/list")
    public Result listadmins() {
        List<Admin> admins = adminService.listAdmins();
        return Result.success(admins);
    }

    // 分页功能
    @GetMapping("/page")
    public Result adminsPage(AdminPageRequest pageRequest) {
        return Result.success(adminService.adminsPage(pageRequest));
    }

    // 新增用户
    @PostMapping("/addadmin")
    public Result addAdmin(@RequestBody Admin admin) {
        adminService.addAdmin(admin);
        return Result.success();
    }

    // 通过查adminId 返回到页面对应的位置的数据
    @GetMapping("/{adminId}")
    public Result getById(@PathVariable Integer adminId) {
        Admin admin = adminService.getById(adminId);
        return Result.success(admin);
    }

    // 更新修改后的用户信息
    @PutMapping("/update")
    public Result update(@RequestBody Admin admin){
        adminService.updateById(admin);
        return Result.success();
    }

    // 根据id删除用户
    @DeleteMapping("/delete/{adminId}")
    public Result delete(@PathVariable Integer adminId) {
        adminService.deleteById(adminId);
        return Result.success();
    }



}
