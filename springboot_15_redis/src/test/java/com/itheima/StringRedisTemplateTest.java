package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class StringRedisTemplateTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void get(){
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        String name1 = stringStringValueOperations.get("name1");
        System.out.println(name1);
    }
}
