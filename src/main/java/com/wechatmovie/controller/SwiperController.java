package com.wechatmovie.controller;


import com.wechatmovie.common.Result;
import com.wechatmovie.controller.request.FilmPageRequest;
import com.wechatmovie.controller.request.SwiperPageRequest;
import com.wechatmovie.entity.Film;
import com.wechatmovie.entity.Swiper;
import com.wechatmovie.service.IFilmService;
import com.wechatmovie.service.ISwiperService;
import com.wechatmovie.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/swiper")

public class SwiperController {
    // 5. controller层实现将数据传递给前端浏览器
    // 对外暴露api

    @Autowired  // 注入
    ISwiperService swiperService;

    // 用户列表
    @GetMapping("/list")
    public Result list() {
        List<Swiper> swipers = swiperService.list();
        return Result.success(swipers);
    }

    // 分页功能
    @GetMapping("/page")
    public Result filmsPage(SwiperPageRequest swiperPageRequest) {
        return Result.success(swiperService.Page(swiperPageRequest));
    }

    // 新增
    @PostMapping("/add")
    public Result add(@RequestBody Swiper swiper) {
        swiperService.add(swiper);
        return Result.success();
    }

    // 通过查 Id 返回到页面对应的位置的数据
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Swiper swiper = swiperService.getById(id);
        return Result.success(swiper);
    }

    // 更新修改后的用户信息
    @PutMapping("/update")
    public Result update(@RequestBody Swiper swiper){
        swiperService.update(swiper);
        return Result.success();
    }

    // 根据id删除
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        swiperService.deleteById(id);
        return Result.success();
    }

    // 上传图片
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        return Result.success(UploadUtil.uploadImage(file));
    }










}
