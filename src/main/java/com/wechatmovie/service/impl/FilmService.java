package com.wechatmovie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatmovie.controller.request.BaseRequest;
import com.wechatmovie.entity.Film;
import com.wechatmovie.mapper.FilmMapper;
import com.wechatmovie.service.IFilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
@Slf4j
public class FilmService implements IFilmService {

    @Resource
    FilmMapper filmMapper;

    // 用户列表
    @Override
    public List<Film> list() {
        return filmMapper.list();
    }

    // 分页
    @Override
    public PageInfo<Film> Page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Film> films = filmMapper.listByCondition(baseRequest);// 按条件查找
        return new PageInfo<>(films);
    }

    @Override
    public void add(Film film) {
        filmMapper.add(film);
    }

    @Override
    public Film getById(Integer id) {
        return filmMapper.getById(id);
    }

    @Override
    public void updateById(Film film) {
        filmMapper.updateById(film);
    }

    @Override
    public void deleteById(Integer id) {
        filmMapper.deleteById(id);
    }


}
