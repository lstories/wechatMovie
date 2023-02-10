package com.wechatmovie.controller.request;

import lombok.Data;

@Data
public class FilmPageRequest extends BaseRequest {
    private String filmName;
}
