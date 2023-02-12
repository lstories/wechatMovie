package com.wechatmovie.controller;


import com.wechatmovie.common.Result;
import com.wechatmovie.controller.request.FilmPageRequest;
import com.wechatmovie.entity.Film;
import com.wechatmovie.service.IFilmService;
import com.wechatmovie.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/film")

public class FilmController {
    // 5. controller层实现将数据传递给前端浏览器
    // 对外暴露api

    @Autowired  // 注入
    IFilmService filmService;

    // 用户列表
    @GetMapping("/list")
    public Result listFilms() {
        List<Film> films = filmService.listFilms();
        return Result.success(films);
    }

    // 分页功能
    @GetMapping("/page")
    public Result filmsPage(FilmPageRequest filmPageRequest) {
        return Result.success(filmService.filmsPage(filmPageRequest));
    }

    // 新增
    @PostMapping("/add")
    public Result addFilm(@RequestBody Film film) {
        filmService.addFilm(film);
        return Result.success();
    }

    // 通过查 Id 返回到页面对应的位置的数据
    @GetMapping("/{id}")
    public Result getByFilmId(@PathVariable Integer id) {
        Film film = filmService.getByFilmId(id);
        return Result.success(film);
    }

    // 更新修改后的用户信息
    @PutMapping("/update")
    public Result update(@RequestBody Film film){
        filmService.updateFilm(film);
        return Result.success();
    }

    // 根据id删除用户
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        filmService.deleteFilmById(id);
        return Result.success();
    }

    // 上传图片
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        return Result.success(UploadUtil.uploadImage(file));
    }










}
