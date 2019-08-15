package com.leebx.pojo;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {

	public static void sendMail(String toAddress,String code,String username,String password){
		Properties props=new Properties();
		props.setProperty("mail.host", "localhost");
		Session session=Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("leebx@lbx.com", "123");
			}
		});
		Message msg=new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress("leebx@lbx.com"));
			msg.addRecipient(RecipientType.TO, new InternetAddress(toAddress));
			msg.setSubject("来自西安粤嵌的激活邮件");
			msg.setContent("<h1>西安粤嵌友情提示您：</h1><h3>点击下面的链接激活邮件</h3><a href='http://localhost:8889/user/activate?code="+code+"&username="+username+"&password="+password+"'>激活链接</a>", "text/html;charset=utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		try {
			Transport.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
