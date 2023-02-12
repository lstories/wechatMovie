package com.wechatmovie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatmovie.controller.request.BaseRequest;
import com.wechatmovie.entity.Category;
import com.wechatmovie.entity.Room;
import com.wechatmovie.mapper.CategoryMapper;
import com.wechatmovie.mapper.RoomMapper;
import com.wechatmovie.service.ICategoryService;
import com.wechatmovie.service.IRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
@Slf4j
public class RoomService implements IRoomService {

    @Resource
    RoomMapper roomMapper;

    // 用户列表
    @Override
    public List<Room> list() {
        return roomMapper.list();
    }

    // 分页
    @Override
    public PageInfo<Room> Page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Room> rooms = roomMapper.listByCondition(baseRequest);// 按条件查找
        return new PageInfo<>(rooms);
    }

    @Override
    public void add(Room room) {
        roomMapper.add(room);
    }

    @Override
    public Room getById(Integer id) {
        return roomMapper.getById(id);
    }

    @Override
    public void updateById(Room room) {
        roomMapper.updateById(room);
    }

    @Override
    public void deleteById(Integer id) {
        roomMapper.deleteById(id);
    }


}
