package com.wechatmovie.controller.request;

import lombok.Data;

@Data
public class RoomPageRequest extends BaseRequest {
    private String spaceBrand;        // 空间类型
    private String styleBrand;    // 风格类型
}
