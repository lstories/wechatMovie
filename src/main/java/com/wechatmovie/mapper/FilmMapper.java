package com.wechatmovie.mapper;

import com.wechatmovie.controller.request.BaseRequest;
import com.wechatmovie.entity.Film;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FilmMapper {
    // 查询所有列表
    List<Film> list();

    // 分页
    List<Film> listByCondition(BaseRequest baseRequest);

    // 新增
    void add(Film obj);

    // 通过Id查询
    Film getById(Integer id);

    // 通过Id更新
    void updateById(Film film);

    // 通过id删除
    void deleteById(Integer id);

}
