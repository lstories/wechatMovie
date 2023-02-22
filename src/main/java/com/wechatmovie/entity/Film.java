package com.wechatmovie.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    private Integer id; // id
    private String filmName;    // 电影名
    private String category;    // 分类
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date time;    // 上映时间
    private String profiles;    // 简介
    private String actor;    // 演员
    private String director;    // 导演
    private String pic;    // 封面
    private BigDecimal price;    // 价格
    private BigDecimal score;    // 评分
    private String video;       // 视频

    private List<String> categories;




}
