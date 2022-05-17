package com.itheima.service.impl.rocketmq.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

//@Component
@RocketMQMessageListener(topic = "order_id", consumerGroup = "group_rocketmq")
public class MessageRocketMqListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String string) {
        System.out.println("已完成短信发送功能 rocketMq");
    }
}
