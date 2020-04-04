package com.sb.springbootoss.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import com.sb.springbootoss.constant.AliyunOSSConfigConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @desc: 阿里云OSS服务相关工具类
 * @author: hanchenghai
 * @date: 2018/12/19 1:19 PM
 * Java API文档地址：https://help.aliyun.com/document_detail/32008.html?spm=a2c4g.11186623.6.703.238374b4PsMzWf
 */
@Component
@Slf4j
public class AliyunOSSUtil {

	private static String FILE_URL;
	private static String bucketName = AliyunOSSConfigConstant.BUCKE_NAME;
	private static String endpoint = AliyunOSSConfigConstant.END_POINT;
	private static String accessKeyId = AliyunOSSConfigConstant.AccessKey_ID;
	private static String accessKeySecret = AliyunOSSConfigConstant.AccessKey_Secret;
	private static String fileHost = AliyunOSSConfigConstant.FILE_HOST;

	/**
	 * 文件上传
	 * @param file
	 * @return
	 */
	public static String upload(File file) {
		boolean isImage = true;
		try {
			Image image = ImageIO.read(file);
			isImage = image == null ? false : true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("------OSS 文件上传开始-------" + file.getName());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = format.format(new Date());

		if (file == null) {
			return null;
		}

		OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		try {
			if (!client.doesBucketExist(bucketName)) {
				client.createBucket(bucketName);
				CreateBucketRequest request = new CreateBucketRequest(bucketName);
				request.setCannedACL(CannedAccessControlList.PublicRead);
				client.createBucket(request);
			}

			String fileUrl = fileHost + "/" + (dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + file.getName());
			if (isImage) {
				//图片可以预览
				FILE_URL = "https://" + bucketName + "." + endpoint + "/" + fileUrl;
			} else {
				FILE_URL = "不是图片，文件路径：" + fileUrl;
			}

			PutObjectResult result = client.putObject(new PutObjectRequest(bucketName, fileUrl, file));
			//权限 公开读
			client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
			if (result != null) {
				log.info("-------OSS 文件上传成功-------" + fileUrl);
			}
		} finally {
			if (client != null) {
				client.shutdown();
			}
			return FILE_URL;
		}
	}

	/**
	 * 文件下载
	 * @param objectName
	 * @param localdFileName
	 */
	public static void downloadFile(String objectName, String localdFileName) {
		OSSClient client = new OSSClient(endpoint,accessKeyId,accessKeySecret);
		//下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
		client.getObject(new GetObjectRequest(bucketName,objectName),new File(localdFileName));
		client.shutdown();
	}

	/**
	 * 列出某个文件夹下的所有文件
	 */
	public static void listFiles(){
		OSSClient client = new OSSClient(endpoint,accessKeyId,accessKeySecret);
		ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);

		//获取test/目录下的文件
		listObjectsRequest.setPrefix("test/");

		ObjectListing listing = client.listObjects(listObjectsRequest);

		System.out.println("Objects:");
		for (OSSObjectSummary summary : listing.getObjectSummaries()) {
			System.out.println(summary.getKey());
		}

		System.out.println("CommonPrefixes:");
		for (String prefix : listing.getCommonPrefixes()) {
			System.out.println(prefix);
		}
		client.shutdown();
	}

}
