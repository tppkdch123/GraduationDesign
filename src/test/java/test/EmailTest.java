package test;


import org.junit.Test;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class EmailTest {


    @Test
    public void test() {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");
        props.setProperty("mail.smtp.host", "smtp.163.com");
        props.setProperty("mail.smtp.port", "25");
        // 指定验证为true
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.timeout", "4000");
        // 验证账号及密码，密码需要是第三方授权码
        Authenticator authenticator = new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("hgftderwsy@163.com", "Aa19960901");
            }
        };
        Session session = Session.getInstance(props, authenticator);
        try {
// 2.创建一个Message，它相当于是邮件内容
            Message message = new MimeMessage(session);
// 设置发送者
            message.setFrom(new InternetAddress("hgftderwsy@163.com"));
// 设置发送方式与接收者
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("hgftderwsy@qq.com"));
// 设置主题
            message.setSubject("邮件发送测试");
// 设置内容
            message.setContent("测试Test", "text/html;charset=utf-8");

// 3.创建 Transport用于将邮件发送
            Transport.send(message);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegex(){
        System.out.println("hgftderwsy@qq-.cn".matches("^[\\w-.]+@[a-z0-9A-Z.-]+.(com|cn)"));
    }
}
