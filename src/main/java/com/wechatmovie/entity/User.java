package com.wechatmovie.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // 1. 实体类
    private Integer userId;     // 用户id
    private String name;        // 用户昵称
    private String username;    // 用户名
    private String password;    // 密码
    private Integer age;        // 年龄
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createtime;    // 创建时间
    private String sex;         // 性别
    private String phone;       // 电话
    private String headpic;     // 头像

}
