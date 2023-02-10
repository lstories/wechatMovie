package com.wechatmovie.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    /**
     * 电影id
     */
    private Integer id;
    /**
     * 电影名称
     */
    private String filmName;
    /**
     * 电影类型
     */
    private String category;
    /**
     * 上映时间
     */
    // @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private String createTime;
    /**
     * 简介
     */
    private String profiles;
    /**
     * 演员
     */
    private String actor;
    /**
     * 导演
     */
    private String director;
    /**
     * 电影封面
     */
    private String pic;
    /**
     * 价格
     */
    private BigDecimal price;

}