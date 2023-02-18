package com.wechatmovie.mapper;


import com.wechatmovie.controller.request.SwiperPageRequest;
import com.wechatmovie.entity.Swiper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper     // 使用Mapper注解,将这个注册为spring的一个bean
public interface SwiperMapper {

    // 2. mapper接口,提供数据库调用的方法

    // 查询所有用户列表
    //  @Select("select * from usertable")
    List<Swiper> list();

    // 分页
    List<Swiper> listByCondition(SwiperPageRequest swiperPageRequest);

    // 新增用户
    void add(Swiper swiper);

    // 通过Id查询
    Swiper getById(Integer id);

    // 通过Id删除
    void updateById(Swiper swiper);

    void deleteById(Integer id);
}


















