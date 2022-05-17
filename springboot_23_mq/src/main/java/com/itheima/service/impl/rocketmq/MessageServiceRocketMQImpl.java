package com.itheima.service.impl.rocketmq;

import com.itheima.service.MessageService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class MessageServiceRocketMQImpl implements MessageService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信已经进入处理队列（rocketmq），id" + id);
//        rocketMQTemplate.convertAndSend("order_id", id);
        SendCallback callback = new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息已经发送完毕");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("消息发送失败！！！！！");
            }
        };
        rocketMQTemplate.asyncSend("order_id", id, callback);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
