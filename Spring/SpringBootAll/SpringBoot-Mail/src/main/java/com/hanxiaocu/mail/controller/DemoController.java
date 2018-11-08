package com.hanxiaocu.mail.controller;

import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/06 3:24 PM
 */
@RestController
@Slf4j
@RequestMapping("/mail")
public class DemoController {

	@Autowired
	JavaMailSender mailSender;

	/**
	 * 纯文本格式
	 *
	 * @return
	 */
	@GetMapping("/simple")
	public String simpleSend() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("374802597@qq.com");
		message.setTo("374802597@qq.com");
		message.setSubject("主题：来自小黑豆的邮件");
		message.setText("你好，我是小黑豆！！！");
		mailSender.send(message);
		return "发送成功";
	}

	/**
	 * 附件格式
	 *
	 * @return
	 */
	@GetMapping("/attach")
	public String attachSend() throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("374802597@qq.com");
		helper.setTo("374802597@qq.com");
		helper.setSubject("主题：来自韩小醋的邮件");
		helper.setText("含附件，你好小黑豆！！！");

		File file = new File("/Users/hanchenghai/Desktop/Practice/JavaPractice/SpringBoot/SpringBootAll/SpringBoot-Mail/src/main/java/com/hanxiaocu/mail/controller/临时.rtf");
		helper.addAttachment("测试.rtf", file);
		mailSender.send(mimeMessage);
		return "附件邮件发送成功";

	}

	/**
	 * html格式
	 *
	 * @return
	 * @throws MessagingException
	 */
	@GetMapping("/html")
	public String htmlSend() throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("374802597@qq.com");
		helper.setTo("374802597@qq.com");
		helper.setSubject("主题：来自BBS的邮件(带附件)");
		helper.setText("<html><body><div>(含附件)这是一封炸弹邮件💣</div><div><img src='cid:File'></div></body></html>", true);
		//抄送人
		//helper.setCc("");
		//密送人
		//helper.setBcc("");
		//添加附件
		//cid(Content-ID)是固定写法，冒号后面的值即为需要替换资源的contentId值，就是对应addInline的资源id
		File file = new File("/Users/hanchenghai/Desktop/Practice/JavaPractice/SpringBoot/SpringBootAll/SpringBoot-Mail/src/main/java/com/hanxiaocu/mail/controller/临时.rtf");
		//建议文件带上后缀，可支持在线预览
		helper.addAttachment("测试.rtf", file);
		helper.addInline("File", file);
		mailSender.send(mimeMessage);
		return "html邮件发送成功!";
	}

	//org.springframework.boot.autoconfigure.freemarker 启动的时候已经注入了
	@Autowired
	freemarker.template.Configuration freemarkerConfig;

	/**
	 * 模板邮件
	 *
	 * @param username
	 * @return
	 * @throws MessagingException
	 */
	@GetMapping("/template")
	public String template(String username) throws MessagingException, IOException, TemplateException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("374802597@qq.com");
		helper.setTo("374802597@qq.com");

		helper.setSubject("主题：" + username + ",你有一封来自韩小醋的邮件");

		Map<String, Object> model = new HashMap<>();
		model.put("username", StringUtils.isEmpty(username) ? "BBS" : username);
		String templateString = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfig.getTemplate("mail.ftl"), model);

		helper.setText(templateString, true);
		//抄送人
		//helper.setCc("");
		//密送人
		//helper.setBcc("");
		//添加附件
		//cid(Content-ID)是固定写法，冒号后面的值即为需要替换资源的contentId值，就是对应addInline的资源id
		File file = new File("/Users/hanchenghai/Desktop/Practice/JavaPractice/SpringBoot/SpringBootAll/SpringBoot-Mail/src/main/java/com/hanxiaocu/mail/controller/临时.rtf");
		//建议文件带上后缀，可支持在线预览
		helper.addAttachment("测试.rtf", file);
		helper.addInline("File", file);
		mailSender.send(mimeMessage);
		return "模板邮件发送成功!";

	}

}
