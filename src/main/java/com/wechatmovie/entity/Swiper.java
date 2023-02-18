package com.wechatmovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Swiper {

    private Integer id; // 轮播图id
    private String filmName;    // 电影名字
    private String photo;   // 轮播图

}
