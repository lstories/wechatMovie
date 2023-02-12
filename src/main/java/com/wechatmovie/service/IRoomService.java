package com.wechatmovie.service;

import com.github.pagehelper.PageInfo;
import com.wechatmovie.controller.request.BaseRequest;
import com.wechatmovie.entity.Room;

import java.util.List;

public interface IRoomService {

    // 查询所有的用户信息
    List<Room> list();

    // 分页
    PageInfo<Room> Page(BaseRequest baseRequest);

    // 添加新用户
    void add(Room room);

    // 通过Id查询到详细信息
    Room getById(Integer id);

    // 修改信息后更新
    void updateById(Room room);

    // 删除
    void deleteById(Integer id);

}
