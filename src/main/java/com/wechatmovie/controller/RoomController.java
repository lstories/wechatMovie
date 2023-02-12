package com.wechatmovie.controller;


import com.wechatmovie.common.Result;
import com.wechatmovie.controller.request.RoomPageRequest;
import com.wechatmovie.entity.Room;
import com.wechatmovie.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired  // 注入
    IRoomService roomService;

    // 用户列表
    @GetMapping("/list")
    public Result list() {
        List<Room> rooms = roomService.list();
        return Result.success(rooms);
    }

    // 分页功能
    @GetMapping("/page")
    public Result Page(RoomPageRequest pageRequest) {
        return Result.success(roomService.Page(pageRequest));
    }

    // 新增用户
    @PostMapping("/add")
    public Result add(@RequestBody Room room) {
        roomService.add(room);
        return Result.success();
    }

    // 通过查adminId 返回到页面对应的位置的数据
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Room room = roomService.getById(id);
        return Result.success(room);
    }

    // 更新修改后的用户信息
    @PutMapping("/update")
    public Result update(@RequestBody Room room){
        roomService.updateById(room);
        return Result.success();
    }

    // 根据id删除用户
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        roomService.deleteById(id);
        return Result.success();
    }

}
