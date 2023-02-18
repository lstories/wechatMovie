package com.wechatmovie.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatmovie.controller.request.SwiperPageRequest;
import com.wechatmovie.entity.Swiper;
import com.wechatmovie.mapper.SwiperMapper;
import com.wechatmovie.service.ISwiperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service    // 注释,标注为spring的组件,才能被调用
public class SwiperService implements ISwiperService {
    // 4. 实现类, 调用mapper接口

    @Autowired
    SwiperMapper swiperMapper;

    // 列表
    @Override
    public List<Swiper> list() {
        return swiperMapper.list();
    }

    // 分页
    @Override
    public Object Page(SwiperPageRequest swiperPageRequest) {
        PageHelper.startPage(swiperPageRequest.getPageNum(), swiperPageRequest.getPageSize());
        List<Swiper> films = swiperMapper.listByCondition(swiperPageRequest);// 按条件查找
        return new PageInfo<>(films);
    }

    // 新增
    @Override
    public void add(Swiper swiper) {
        swiperMapper.add(swiper);
    }


    // 查询当前id的信息
    @Override
    public Swiper getById(Integer id) {
        return swiperMapper.getById(id);
    }

    // 修改信息后更新
    @Override
    public void update(Swiper swiper) {
        swiperMapper.updateById(swiper);
    }

    // 删除
    @Override
    public void deleteById(Integer id) {
        swiperMapper.deleteById(id);
    }


}
