package com.wechatmovie.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Integer id;     // id
    private String name;        // 类型名字
    private String remark;    // 备注
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate createTime;    // 创建时间
    private Integer pid;     // 父id

    private List<Category> children;


}
