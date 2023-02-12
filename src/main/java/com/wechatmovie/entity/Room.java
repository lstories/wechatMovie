package com.wechatmovie.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private Integer id;     // id
    private String spaceBrand;        // 空间类型
    private String styleBrand;    // 风格类型
    private BigDecimal price;       // 价格
    private Boolean status;     // 状态
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate createTime;    // 创建时间




}
