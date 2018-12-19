package com.sb.springbootoss.controller;

import com.sb.springbootoss.utils.AliyunOSSUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/19 1:39 PM
 */
@RestController("/oss")
@Slf4j
public class AliyunOSSController {

	@RequestMapping("/upload")
	@ResponseBody
	public String upload() {
		File file = new File("xxxxx");
		String url = AliyunOSSUtil.upload(file);
		System.out.println(url);
		return "success";
	}

	@RequestMapping("/download")
	@ResponseBody
	public String download() {
		AliyunOSSUtil.downloadFile("test/2018-12-19/xxxxxxxx.jpg", "/User/hanchenghai/Desktop/xx.jpg");
		return "success";
	}

	@RequestMapping("listFiles")
	@ResponseBody
	public String listFiles() {
		AliyunOSSUtil.listFiles();
		return "success";
	}

	@RequestMapping("/uploadFile")
	public String uploadPic(@RequestParam("file") MultipartFile file, Model model) {
		log.info("文件上传...");
		String filename = file.getOriginalFilename();
		System.out.println(filename);

		try {
			if (file != null) {
				if (!"".equals(filename.trim())) {
					File newFile = new File(filename);
					FileOutputStream os = new FileOutputStream(newFile);
					os.write(file.getBytes());
					os.close();
					file.transferTo(newFile);
					String uploadUrl = AliyunOSSUtil.upload(newFile);
					model.addAttribute("url", uploadUrl);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

}
