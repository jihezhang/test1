package com.itheima.service.impl;

import com.itheima.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendMailServiceImpl2 implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    //收件人
    private String from = "1016954311@qq.com";
    //发送人
    private String to = "3296615665@qq.com";
    //标题
    private String subject = "发送图片连接";
    //正文
    private String context = "<a href='http://www.baidu.com'/>点开有进行</a>";
    private String context1 = "<img src='https://tse1-mm.cn.bing.net/th/id/R-C.916e0cdc29b9ec53ee5d85ae8e4ea785?rik=09JVDuS8XeWbRw&riu=http%3a%2f%2fwtkoss.weituk.com%2fwp-content%2fuploads%2f2020%2f11%2f5fae49301b8b8.jpg&ehk=kK8jUy16myzwJYxO9F%2b%2fyS7ndQGVKwLtY%2feKwhYI5Fs%3d&risl=&pid=ImgRaw&r=0'/>";
    @Override
    public void sendMail() {
        try {
            MimeMessage messge = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(messge, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(context1, true);
            //发送附件的时候需要使用helper的addAttachment方法
            File file1 = new File("F:\\javacode\\springboot\\springboot_22_mail\\target\\springboot_22_test-0.0.1-SNAPSHOT.jar");
            mimeMessageHelper.addAttachment("打包文件", file1);
            javaMailSender.send(messge);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
