package com.hanxiaocu.mail.service;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/25 3:26 PM
 */
public interface Mailservice {
	public void sendSimpleMail(String to, String subject, String content);


	public void sendHtmlMail(String to, String subject, String content);
}
