package com.wechatmovie.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    private Integer adminId;     // id
    private String name;        // 昵称
    private String adminName;    // 用户名
    private String phone;     // 手机号
    private String headpic;     // 头像
    private String token;       // token

}
