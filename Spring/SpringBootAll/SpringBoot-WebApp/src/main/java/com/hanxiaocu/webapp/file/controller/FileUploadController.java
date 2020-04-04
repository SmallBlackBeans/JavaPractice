package com.hanxiaocu.webapp.file.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/02 3:11 PM
 */
@Controller
@Slf4j
@RequestMapping("/uploads")
public class FileUploadController {

	@GetMapping
	public String index() {
		return "index";
	}

	/**
	 * 单文件上传
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/upload1")
	@ResponseBody
	public Map<String, String> upload1(@RequestParam MultipartFile file) throws IOException {
		Map<String, String> result = new HashMap<>(16);
		if (file.isEmpty()) {
			result.put("400", "上传文件不能为空");
			return result;
		}
		log.info("[服务器文件名] - [{}]", file.getName());
		log.info("[文件类型] - [{}]", file.getContentType());
		log.info("[文件名称] - [{}]", file.getOriginalFilename());
		log.info("[文件大小] - [{}]", file.getSize());
		// TODO 将文件写入到指定目录（具体开发中有可能是将文件写入到云存储/或者指定目录通过 Nginx 进行 gzip 压缩和反向代理
		String origFileName = file.getOriginalFilename();

		file.transferTo(new File("/Users/hanchenghai/Desktop/Practice/JavaPractice/SpringBoot/SpringBootAll/SpringBoot-WebApp/src/main/resources/upload/" + origFileName));

		result.put("result", "方式文件上传成功!");
		result.put("文件名", file.getOriginalFilename());
		result.put("文件类型", file.getContentType());
		result.put("文件大小", file.getSize() + "");
		// return String.format(file.getClass().getName() + "方式文件上传成功！\n文件名：%s,文件类型：%s,文件大小：%s", origFileName, contentType, fileSize);

		return result;
	}

	/**
	 * 多文件上传
	 * @param files
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/upload2")
	@ResponseBody
	public List<Map<String, String>> upload2(@RequestParam("file") MultipartFile[] files) throws IOException {
		if (files == null || files.length == 0) {
			return null;
		}
		List<Map<String, String>> results = new ArrayList<>();
		for (MultipartFile file : files) {
			// TODO Spring Mvc 提供的写入方式
			String origFileName = file.getOriginalFilename();
			file.transferTo(new File("/Users/hanchenghai/Desktop/Practice/JavaPractice/SpringBoot/SpringBootAll/SpringBoot-WebApp/src/main/resources/upload/" + origFileName));
			Map<String, String> map = new HashMap<>(16);
			map.put("contentType", file.getContentType());
			map.put("fileName", file.getOriginalFilename());
			map.put("fileSize", file.getSize() + "");
			results.add(map);
		}
		return results;
	}

	/**
	 * Base64 上传
	 * @param base64
	 * @throws IOException
	 */
	@PostMapping("/upload3")
	@ResponseBody
	public void upload3(String base64) throws IOException {
		// TODO BASE64 方式的 格式和名字需要自己控制（如 png 图片编码后前缀就会是 data:image/png;base64,）
		final File tempFile =  new File("/Users/hanchenghai/Desktop/Practice/JavaPractice/SpringBoot/SpringBootAll/SpringBoot-WebApp/src/main/resources/upload/test.png");

		// TODO 防止有的传了 data:image/png;base64, 有的没传的情况
		String[] d = base64.split("base64,");
		final byte[] bytes = Base64Utils.decodeFromString(d.length > 1 ? d[1] : d[0]);
		FileCopyUtils.copy(bytes, tempFile);

	}


}
