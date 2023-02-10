package com.wechatmovie.service;

import com.github.pagehelper.PageInfo;
import com.wechatmovie.controller.request.BaseRequest;
import com.wechatmovie.entity.Film;

import java.util.List;

public interface IFilmService {

    // 查询所有的用户信息
    List<Film> list();

    // 分页
    PageInfo<Film> Page(BaseRequest baseRequest);

    // 添加新用户
    void add(Film film);

    // 通过Id查询到详细信息
    Film getById(Integer id);

    // 修改信息后更新
    void updateById(Film film);

    // 删除
    void deleteById(Integer id);

}
