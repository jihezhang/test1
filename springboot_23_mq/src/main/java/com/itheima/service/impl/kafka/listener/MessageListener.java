package com.itheima.service.impl.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @KafkaListener(topics = {"itheima"})
    public void onMessage(ConsumerRecord<String, String> record) {
        System.out.println("已完成短信发送功能 Kafka:::" + record.value());
    }
}
