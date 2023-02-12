package com.wechatmovie.mapper;


import com.wechatmovie.controller.request.BaseRequest;
import com.wechatmovie.entity.Category;
import com.wechatmovie.entity.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper     // 使用Mapper注解,将这个注册为spring的一个bean
public interface RoomMapper {

    // 查询所有列表
    List<Room> list();

    // 分页
    List<Room> listByCondition(BaseRequest baseRequest);

    // 新增
    void add(Room obj);

    // 通过Id查询
    Room getById(Integer id);

    // 通过Id更新
    void updateById(Room room);

    // 通过id删除
    void deleteById(Integer id);

}


















