package com.wechatmovie.controller.request;


import lombok.Data;

@Data
public class OrderRequest extends BaseRequest {


    private String userName;     // 用户名
    private String filmName;     // 电影名
    private Integer roomId;     // id

}
