package com.fc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@SpringBootTest
public class MailTest {
    //java的邮件发送器
    @Autowired
    private JavaMailSender sender;

    @Test
    void testHtmlMail() {
        String content = "<img src='https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fweixin.sanbiaoge.com%2Fcunchu5%2F2021-02-07%2F4_16126366717967458.jpg&refer=http%3A%2F%2Fweixin.sanbiaoge.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1653634723&t=3453e2ae22329ffc6faa90a98f73a147' alt='图片'>" +
                "<font align='center' color='red'>" +
                "如果你是花朵，我愿做一只蝴蝶，愿真爱永远环绕着你；如果你是白云，我愿做一缕清风，愿真情永远跟随着你，我爱你，我要告诉你，我会陪伴你到永远。" +
                "</font>";
        //html类型邮件
        MimeMessage mimeMessage = sender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setFrom("2770285014@qq.com");

            helper.setTo("1394554684@qq.com");

            helper.setSubject("爱你");

            helper.setText(content, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        sender.send(mimeMessage);
    }

    @Test
    void testSimpleMail(){
        //创建一个简单邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        //设置邮件的发送人
        message.setFrom("2770285014@qq.com");
        //设置邮件的接收人
        message.setTo("1394554684@qq.com" ,
                "2270307693@qq.com",
                "2440637611@qq.com");

        //设置邮件的主题
        message.setSubject("面试offer通知");
        //设置邮件的内容
        message.setText("");

        sender.send(message);
    }
}
