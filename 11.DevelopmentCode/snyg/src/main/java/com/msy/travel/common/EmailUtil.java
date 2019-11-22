package com.msy.travel.common;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EmailUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(EmailUtil.class);

	/**
	 * 发送邮件
	 * 
	 * @author whn
	 * @date 2015年9月8日 下午1:57:10
	 * @param emailAddress
	 *            被发送人地址
	 * @param subject
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 * @return boolean 发送成功返回true 发送失败返回 false
	 */
	public static boolean SingleMailSend(String emailAddress, String subject, String content) {
		boolean result = true;
		try {
			// String sendAddress = "msy@wootide.com";
			String sendAddress = PropertyUtil.getPropertyByKey("email.address");
			// String password = "Wootide123456";
			String password = PropertyUtil.getPropertyByKey("email.password");
			// String sendNickName = "马上游产品分销平台";
			String sendNickName = PropertyUtil.getPropertyByKey("email.nickName");

			Properties properties = new Properties();
			// properties.put("mail.smtp.host", "smtp.exmail.qq.com");
			properties.put("mail.smtp.host", PropertyUtil.getPropertyByKey("email.mail.smtp.host"));
			// properties.put("mail.smtp.port", "25");
			properties.put("mail.smtp.port", PropertyUtil.getPropertyByKey("email.mail.smtp.port"));
			// properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.auth", PropertyUtil.getPropertyByKey("email.mail.smtp.auth"));
			Authenticator authenticator = new Email_Authenticator(sendAddress, password);
			javax.mail.Session sendMailSession = javax.mail.Session.getDefaultInstance(properties, authenticator);
			MimeMessage mailMessage = new MimeMessage(sendMailSession);
			mailMessage.setFrom(new InternetAddress(sendAddress, sendNickName));
			// Message.RecipientType.TO属性表示接收者的类型为TO
			mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
			mailMessage.setSubject(subject, "UTF-8");
			mailMessage.setSentDate(new Date());
			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart mainPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart html = new MimeBodyPart();
			html.setContent(content.trim(), "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			mailMessage.setContent(mainPart);
			Transport.send(mailMessage);
		} catch (Exception ex) {
			log.error("发送邮件失败.email[" + emailAddress + "],content[" + content + "]");
			ex.printStackTrace();
			result = false;
		}

		return result;
	}

	public static void main(String args[]) {
		EmailUtil.SingleMailSend("test@wootide.com", "邮件主题", "邮件内容<br/>111");

	}
}
