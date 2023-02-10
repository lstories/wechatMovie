package com.wechatmovie.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatmovie.controller.request.FilmPageRequest;
import com.wechatmovie.entity.Film;
import com.wechatmovie.mapper.FilmMapper;
import com.wechatmovie.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service    // 注释,标注为spring的组件,才能被调用
public class FilmService implements IFilmService {
    // 4. 实现类, 调用mapper接口

    @Autowired
    FilmMapper filmMapper;

    // 用户列表
    @Override
    public List<Film> listFilms() {
        return filmMapper.listFilms();
    }

    // 分页
    @Override
    public Object filmsPage(FilmPageRequest filmPageRequest) {
        PageHelper.startPage(filmPageRequest.getPageNum(), filmPageRequest.getPageSize());
        List<Film> films = filmMapper.listByCondition(filmPageRequest);// 按条件查找
        return new PageInfo<>(films);
    }

    // 新增用户
    @Override
    public void addFilm(Film film) {
        filmMapper.addFilm(film);
    }

    // 查询当前id的用户信息
    @Override
    public Film getByFilmId(Integer id) {
        return filmMapper.getByFilmId(id);
    }

    // 修改信息后更新
    @Override
    public void updateFilm(Film film) {
        filmMapper.updateFilmById(film);
    }

    @Override
    public void deleteFilmById(Integer id) {
        filmMapper.deleteFilmById(id);
    }


}
