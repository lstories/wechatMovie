package com.wechatmovie.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    // 1. 实体类
    private Integer adminId;     // 用户id
    private String name;        // 用户昵称
    private String adminName;    // 用户名
    private String password;    // 密码
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;    // 创建时间
    private String phone;     // 手机号
    private String headpic;     // 头像
}
