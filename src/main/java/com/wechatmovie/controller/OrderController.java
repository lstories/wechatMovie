package com.wechatmovie.controller;


import com.wechatmovie.common.Result;
import com.wechatmovie.controller.request.OrderRequest;
import com.wechatmovie.entity.Order;
import com.wechatmovie.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")

public class OrderController {

    @Autowired  // 注入
    IOrderService orderService;

    // 列表
    @GetMapping("/list")
    public Result list() {
        List<Order> orders = orderService.list();
        return Result.success(orders);
    }

    // 分页功能
    @GetMapping("/page")
    public Result Page(OrderRequest orderRequest) {
        return Result.success(orderService.Page(orderRequest));
    }

    // 新增用户
    @PostMapping("/adduser")
    public Result addUser(@RequestBody Order order) {
        orderService.add(order);
        return Result.success();
    }

    // 通过查userId 返回到页面对应的位置的数据
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Order order = orderService.getById(id);
        return Result.success(order);
    }

    // 更新修改后的用户信息
    @PutMapping("/update")
    public Result update(@RequestBody Order order){
        orderService.update(order);
        return Result.success();
    }

    // 根据id删除用户
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        orderService.deleteById(id);
        return Result.success();
    }












}
