package com.wechatmovie.mapper;


import com.wechatmovie.controller.request.FilmPageRequest;
import com.wechatmovie.controller.request.UserPageRequest;
import com.wechatmovie.entity.Film;
import com.wechatmovie.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper     // 使用Mapper注解,将这个注册为spring的一个bean
public interface FilmMapper {

    // 查询评分最高的前10个
    List<Film> heightTen();

    // 2. mapper接口,提供数据库调用的方法

    // 查询所有用户列表
    //  @Select("select * from usertable")
    List<Film> listFilms();

    // 分页
    List<Film> listByCondition(FilmPageRequest filmPageRequest);

    // 新增用户
    void addFilm(Film film);

    // 通过Id查询
    Film getByFilmId(Integer id);

    // 通过Id删除
    void updateFilmById(Film film);

    void deleteFilmById(Integer id);

    List<Film> filmsCategory(FilmPageRequest filmPageRequest);

    List<Film> byCategory(FilmPageRequest filmPageRequest);


}


















