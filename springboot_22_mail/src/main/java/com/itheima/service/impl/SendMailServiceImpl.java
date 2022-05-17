package com.itheima.service.impl;

import com.itheima.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.mail.internet.MimeMessage;

//@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    //收件人
    private String from = "1016954311@qq.com";
    //发送人
    private String to = "857515821@qq.com";
    //标题
    private String subject = "崔明泽给我大声读出来";
    //正文
    private String context = "崔明泽可真帅啊";

    @Override
    public void sendMail() {
        //创建简单邮件信息
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from+"(小甜甜)");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);
        javaMailSender.send(message);
    }
}
