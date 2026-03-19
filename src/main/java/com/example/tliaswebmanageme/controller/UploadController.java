package com.example.tliaswebmanageme.controller;

import com.example.tliaswebmanageme.Utils.OssJavaSdkQuickStart;
import com.example.tliaswebmanageme.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class UploadController {

    @Autowired
    private OssJavaSdkQuickStart ossJavaSdkQuickStart;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        String filename = file.getOriginalFilename();
        String url = ossJavaSdkQuickStart.upload(file.getBytes(), filename);
        log.info("上传成功{}", filename);
        return Result.success(url);
    }
}
