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
public class Order {
    private Integer id;     // id
    private Integer userid;     // 用户名
    private Integer filmid;     // 电影名
    private Integer roomid;     // id
    private BigDecimal price;    // 价格
    private String brand;        // 类型(平团/预约)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date createtime;    // 备注
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date begintime;    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date endtime;    // 创建时间
    private String captcha;     // 验证码


}
