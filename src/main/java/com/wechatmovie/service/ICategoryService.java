package com.wechatmovie.service;

import com.github.pagehelper.PageInfo;
import com.wechatmovie.controller.request.BaseRequest;
import com.wechatmovie.entity.Category;

import java.util.List;

public interface ICategoryService {

    // 查询所有的用户信息
    List<Category> list();

    // 分页
    PageInfo<Category> Page(BaseRequest baseRequest);

    // 添加新用户
    void add(Category category);

    // 通过Id查询到详细信息
    Category getById(Integer id);

    // 修改信息后更新
    void updateById(Category category);

    // 删除
    void deleteById(Integer id);

}
