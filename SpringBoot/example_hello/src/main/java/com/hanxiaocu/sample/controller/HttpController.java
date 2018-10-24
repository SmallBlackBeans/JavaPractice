package com.hanxiaocu.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/24 9:06 AM
 */


@Controller
@RequestMapping("/")
public class HttpController {

    @PostMapping(path = "/filesUpload.html")
    @ResponseBody
    public ModelMap handleFormUpload(String name, MultipartFile[] files) throws IOException {
        int successCount = 0;
        int failureCount = 0;
        for (MultipartFile file : files) {
            if (handleFile(file)) {
                successCount++;
            } else {
                failureCount++;
            }
        }
        ModelMap map = new ModelMap();
        map.put("success", successCount);
        map.put("failure", failureCount);
        return map;
    }

    public boolean handleFile(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String      filename = file.getOriginalFilename();
            InputStream ins      = file.getInputStream();
            //处理文件上传

            return true;
        } else {
            return false;
        }
    }





}
