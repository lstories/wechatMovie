package com.wechatmovie.mapper;


import com.wechatmovie.controller.request.BaseRequest;
import com.wechatmovie.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper     // 使用Mapper注解,将这个注册为spring的一个bean
public interface CategoryMapper {

    // 查询所有列表
    List<Category> list();

    // 分页
    List<Category> listByCondition(BaseRequest baseRequest);

    // 新增
    void add(Category obj);

    // 通过Id查询
    Category getById(Integer id);

    // 通过Id更新
    void updateById(Category category);

    // 通过id删除
    void deleteById(Integer id);

}


















