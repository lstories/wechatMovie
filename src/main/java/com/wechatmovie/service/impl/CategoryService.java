package com.wechatmovie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatmovie.controller.request.BaseRequest;
import com.wechatmovie.entity.Category;
import com.wechatmovie.mapper.CategoryMapper;
import com.wechatmovie.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
@Slf4j
public class CategoryService implements ICategoryService {

    @Resource
    CategoryMapper categoryMapper;

    // 用户列表
    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }

    // 分页
    @Override
    public PageInfo<Category> Page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Category> categories = categoryMapper.listByCondition(baseRequest);// 按条件查找
        return new PageInfo<>(categories);
    }

    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }

    @Override
    public Category getById(Integer id) {
        return categoryMapper.getById(id);
    }

    @Override
    public void updateById(Category category) {
        categoryMapper.updateById(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryMapper.deleteById(id);
    }


}
