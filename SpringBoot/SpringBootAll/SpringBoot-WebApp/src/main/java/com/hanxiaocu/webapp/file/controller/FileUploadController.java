package com.hanxiaocu.webapp.file.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/02 3:11 PM
 */
@RestController
@Slf4j
public class FileUploadController {


	@PostMapping("/upload")
	public String upload(@RequestParam MultipartFile file) throws IOException {
		if (file.isEmpty()) {
			return "上传文件不能为空";
		}
		//文件类型
		String contentType = file.getContentType();
		String fileName = file.getName();
		log.info("服务器文件名：" + fileName);

		String origFileName = file.getOriginalFilename();
		long fileSize = file.getSize();

		file.transferTo(new File("/Users/hanchenghai/Desktop/Practice/JavaPractice/SpringBoot/SpringBootAll/SpringBoot-WebApp/src/main/resources/upload/" + origFileName));

		return String.format(file.getClass().getName() + "方式文件上传成功！\n文件名：%s,文件类型：%s,文件大小：%s",origFileName,contentType,fileSize);

	}


}
