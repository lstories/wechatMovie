package com.wechatmovie.service;

import com.wechatmovie.controller.request.FilmPageRequest;
import com.wechatmovie.entity.Film;

import java.util.List;

public interface IFilmService {
    // 3. 业务处理层, 操作数据库, 先写个接口

    // 查询所有的用户信息
    List<Film> listFilms();

    // 分页
    Object filmsPage(FilmPageRequest filmPageRequest);

    // 添加新用户
    void addFilm(Film film);

    // 通过Id查询到详细信息
    Film getByFilmId(Integer id);

    // 修改信息后更新
    void updateFilm(Film film);

    void deleteFilmById(Integer id);

    // 查询评分最高的前10个
    List<Film> heightTen();

    Object filmsCategory(FilmPageRequest filmPageRequest);
    // 通过名字查找
    Object byCategory(FilmPageRequest filmPageRequest);



}
