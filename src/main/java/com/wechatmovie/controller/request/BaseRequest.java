package com.wechatmovie.controller.request;


import lombok.Data;

@Data
public class BaseRequest {

    private Integer pageNum = 1;    // 页数
    private Integer pageSize = 10;   // 一页多少个

}
