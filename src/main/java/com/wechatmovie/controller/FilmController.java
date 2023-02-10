package com.wechatmovie.controller;


import com.wechatmovie.common.Result;
import com.wechatmovie.controller.request.FilmPageRequest;
import com.wechatmovie.entity.Film;
import com.wechatmovie.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/film")
public class FilmController {
    // 5. controller层实现将数据传递给前端浏览器
    // 对外暴露api

    @Autowired  // 注入
    IFilmService filmService;

    // 用户列表
    @GetMapping("/list")
    public Result list() {
        List<Film> films = filmService.list();
        return Result.success(films);
    }

    // 分页功能
    @GetMapping("/page")
    public Result Page(FilmPageRequest pageRequest) {
        return Result.success(filmService.Page(pageRequest));
    }

    // 新增用户
    @PostMapping("/add")
    public Result add(@RequestBody Film film) {
        filmService.add(film);
        return Result.success();
    }

    // 通过查adminId 返回到页面对应的位置的数据
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Film film = filmService.getById(id);
        return Result.success(film);
    }

    // 更新修改后的用户信息
    @PutMapping("/update")
    public Result update(@RequestBody Film film){
        filmService.updateById(film);
        return Result.success();
    }

    // 根据id删除用户
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        filmService.deleteById(id);
        return Result.success();
    }












}
