package com.itheima.service.impl.rabbitmq.direct;

import com.itheima.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class MessageServiceRabbitMqDirect implements MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信已经进入处理队列（rabbitmq direct），id" + id);
        amqpTemplate.convertAndSend("direct_exchange", "direct", id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
