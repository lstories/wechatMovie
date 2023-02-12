package com.wechatmovie.mapper;


import com.wechatmovie.controller.request.OrderRequest;
import com.wechatmovie.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper     // 使用Mapper注解,将这个注册为spring的一个bean
public interface OrderMapper {

    // 2. mapper接口,提供数据库调用的方法

    // 查询所有用户列表
    List<Order> list();

    // 分页
    List<Order> listByCondition(OrderRequest orderRequest);

    // 新增用户
    void add(Order order);

    // 通过Id查询
    Order getById(Integer id);

    // 通过Id删除
    void updateById(Order order);

    void deleteById(Integer id);
}


















