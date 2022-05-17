package com.itheima.service.impl.rabbitmq.topic.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class MessageRabbitMqListener {

    @RabbitListener(queues = "topic_queue")
    public void receive() {
        System.out.println("已完成短信发送功能 topic11111");
    }

    @RabbitListener(queues = "topic_queue2")
    public void receive2() {
        System.out.println("已完成短信发送功能 topic22222");
    }
}
