package com.wechatmovie.controller.request;


import lombok.Data;

@Data
public class SwiperPageRequest extends BaseRequest {


    private Integer id; // 轮播图id
    private String photo;   // 轮播图

}
