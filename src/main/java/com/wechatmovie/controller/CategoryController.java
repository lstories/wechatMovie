package com.wechatmovie.controller;


import cn.hutool.core.collection.CollUtil;
import com.wechatmovie.common.Result;
import com.wechatmovie.controller.request.CategoryPageRequest;
import com.wechatmovie.entity.Category;
import com.wechatmovie.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired  // 注入
    ICategoryService categoryService;

    // 用户列表
    @GetMapping("/list")
    public Result list() {
        List<Category> categories = categoryService.list();
        return Result.success(categories);
    }

    // 分页功能
    @GetMapping("/page")
    public Result Page(CategoryPageRequest pageRequest) {
        return Result.success(categoryService.Page(pageRequest));
    }

    // 新增用户
    @PostMapping("/add")
    public Result add(@RequestBody Category category) {
        categoryService.add(category);
        return Result.success();
    }

    // 通过查adminId 返回到页面对应的位置的数据
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Category category = categoryService.getById(id);
        return Result.success(category);
    }

    // 更新修改后的用户信息
    @PutMapping("/update")
    public Result update(@RequestBody Category category){
        categoryService.updateById(category);
        return Result.success();
    }

    // 根据id删除用户
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return Result.success();
    }

    // 获取分类列表
    @GetMapping("tree")
    public Result tree() {
        List<Category> list = categoryService.list();
        // 对list操作

        return Result.success(createTree(null, list));
    }

    private List<Category> createTree(Integer pid, List<Category> categories) {
        List<Category> treeList = new ArrayList<>();
        for (Category category : categories) {
            if (pid == null) {
                if (category.getPid() == null){
                    treeList.add(category);
                    category.setChildren(createTree(category.getId(), categories));
                }
            }else{
                if (pid.equals(category.getPid())){
                    treeList.add(category);
                    category.setChildren(createTree(category.getId(), categories));
                }
            }
            if (CollUtil.isEmpty(category.getChildren())) {
                category.setChildren(null);
            }
        }
        return treeList;
    }









}
