package com.wechatmovie.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest extends BaseRequest {

    private String adminName;   // 管理员账号
    private String password;    // 管理员密码

}
