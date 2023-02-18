package com.wechatmovie.service;

import com.wechatmovie.controller.request.SwiperPageRequest;
import com.wechatmovie.entity.Swiper;

import java.util.List;

public interface ISwiperService {
    // 3. 业务处理层, 操作数据库, 先写个接口

    // 查询所有的信息
    List<Swiper> list();

    // 分页
    Object Page(SwiperPageRequest swiperPageRequest);

    // 添加
    void add(Swiper swiper);

    // 通过Id查询到详细信息
    Swiper getById(Integer id);

    // 修改信息后更新
    void update(Swiper swiper);

    void deleteById(Integer id);


}
