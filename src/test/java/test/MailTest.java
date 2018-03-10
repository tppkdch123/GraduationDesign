package test;

import javax.mail.Authenticator;
import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailTest {
   private static final String HOST="imap.163.com";
   private static final Integer PORT=25;
   private static final String USERNAME="hgftderwsy";
   private static final String PASSWORD="Aa19960901";
   private static final String op="hydynxfltmhmbcei";

@Test
    public void testSendEmail(){
        JavaMailSenderImpl javaMailSender=new JavaMailSenderImpl();
        javaMailSender.setDefaultEncoding("Utf-8");
        javaMailSender.setHost(HOST);
        javaMailSender.setProtocol("imap");
        javaMailSender.setUsername(USERNAME);
        javaMailSender.setPort(PORT);
        Properties properties=new Properties();
        properties.setProperty("mail.imap.timeout","25000");
        properties.setProperty("mail.imap.auth","false");
        javaMailSender.setJavaMailProperties(properties);

    MimeMessage mimeMessage=javaMailSender.createMimeMessage();
    try {
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true,"Utf-8");
        mimeMessageHelper.setFrom(USERNAME+"@163.com");
        mimeMessageHelper.setSubject("hello world");
        mimeMessageHelper.setText("测试邮件发送");
        mimeMessageHelper.setTo("hgftderwsy@qq.com");
        javaMailSender.send(mimeMessage);
    } catch (MessagingException e) {
        e.printStackTrace();
    }
    }

}
