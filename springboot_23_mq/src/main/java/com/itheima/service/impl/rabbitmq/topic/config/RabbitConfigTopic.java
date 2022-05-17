package com.itheima.service.impl.rabbitmq.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RabbitConfigTopic {
    @Bean
    public Queue topicQueue() {
        return new Queue("topic_queue");
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue("topic_queue2");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic_exchange");
    }

    @Bean
    public Binding bindingTopic() {
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.*.*");
    }

    //一个交换机可以绑定多个消息队列
    @Bean
    public Binding bindingTopic2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic.sim.*");
    }
}