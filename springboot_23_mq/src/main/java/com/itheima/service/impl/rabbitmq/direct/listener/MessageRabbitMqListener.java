package com.itheima.service.impl.rabbitmq.direct.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class MessageRabbitMqListener {

    @RabbitListener(queues = "direct_queue")
    public void receive() {
        System.out.println("已完成短信发送功能");
    }
}
