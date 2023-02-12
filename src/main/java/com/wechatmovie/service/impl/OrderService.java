package com.wechatmovie.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatmovie.controller.request.OrderRequest;
import com.wechatmovie.entity.Order;
import com.wechatmovie.mapper.OrderMapper;
import com.wechatmovie.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service    // 注释,标注为spring的组件,才能被调用
public class OrderService implements IOrderService {
    // 4. 实现类, 调用mapper接口

    @Autowired
    OrderMapper orderMapper;

    // 用户列表
    @Override
    public List<Order> list() {
        return orderMapper.list();
    }

    // 分页
    @Override
    public Object Page(OrderRequest orderRequest) {
        PageHelper.startPage(orderRequest.getPageNum(), orderRequest.getPageSize());
        List<Order> orders = orderMapper.listByCondition(orderRequest);// 按条件查找
        return new PageInfo<>(orders);
    }

    // 新增用户
    @Override
    public void add(Order order) {
        orderMapper.add(order);
    }

    // 查询当前id的用户信息
    @Override
    public Order getById(Integer id) {
        return orderMapper.getById(id);
    }

    // 修改信息后更新
    @Override
    public void update(Order order) {
        orderMapper.updateById(order);
    }

    @Override
    public void deleteById(Integer id) {
        orderMapper.deleteById(id);
    }


}
