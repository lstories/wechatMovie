package com.wechatmovie.utils;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Component
@Slf4j
public class UploadUtil {
    // 阿里域名
    public static final String ALI_DOMAIN = "https://lstories.oss-cn-guangzhou.aliyuncs.com/";

    public static String uploadImage(MultipartFile file) throws IOException {
        // 生成文件名
        String originalFilename = file.getOriginalFilename();   // 原来的图片名
        String ext = "." + FilenameUtils.getExtension(originalFilename);
        String uuid = UUID.randomUUID().toString().replace("-","");
        String fileName = uuid + ext;
        // 地域节点
        String endpoint = "http://oss-cn-guangzhou.aliyuncs.com";
        String accessKeyId = "LTAI5tECVMqYtmvp7iCwwZXd";
        String accessKeySecret = "syzOOjNZslswHXqzC9K72EZEmbLaOO";
        // OSS客户端对象
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject("lstories", fileName, file.getInputStream());   // 仓库名, 文件名, 抛异常
        ossClient.shutdown();
        return ALI_DOMAIN + fileName;
    }


}
