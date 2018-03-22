package org.graduationdesign.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class EmailUtil {

    @Value("${qq.mail.smtp.username}")
    private String qqEmail;

    @Value("${163.mail.smtp.username}")
    private String email163;

    @Autowired
    @Qualifier("qqEmailProperties")
    private Properties qqProperties;

    @Autowired
    @Qualifier("qqAccount")
    private Authenticator qqAuthenticator;

    @Autowired
    @Qualifier("emailProperties163")
    private Properties properties163;

    @Autowired
    @Qualifier("account163")
    private Authenticator authenticator163;


    public void sendMessageByQQEmail(String mailname, String subject, String content) {
       sendEmail(qqEmail,mailname,subject,content,qqProperties,qqAuthenticator);

    }

    public void sendMessageBy163Email(String mailname,String subject,String content){
        sendEmail(email163,mailname,subject,content,properties163,authenticator163);
    }

    public void sendEmail(String sender,String mailname,String subject,String content,Properties properties,Authenticator authenticator){
        try {
            Message message = new MimeMessage(Session.getInstance(properties,authenticator));
            message.setFrom(new InternetAddress(sender));
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(mailname));
            message.setSubject(subject);
            message.setContent(content, "text/html;charset=utf-8");
            Transport.send(message);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }
}
