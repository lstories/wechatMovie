package com.wechatmovie.service;

import com.wechatmovie.controller.request.OrderRequest;
import com.wechatmovie.controller.request.UserPageRequest;
import com.wechatmovie.entity.Order;
import com.wechatmovie.entity.User;

import java.util.List;

public interface IOrderService {
    // 3. 业务处理层, 操作数据库, 先写个接口

    // 查询所有的用户信息
    List<Order> list();

    // 分页
    Object Page(OrderRequest orderRequest);

    // 添加新用户
    void add(Order order);

    // 通过Id查询到详细信息
    Order getById(Integer id);

    // 修改信息后更新
    void update(Order order);

    void deleteById(Integer id);
}
