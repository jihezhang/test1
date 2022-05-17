package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class Springboot15RedisApplicationTests {
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	void set() {
		ValueOperations valueOperations = redisTemplate.opsForValue();
		valueOperations.set("key1", "zhangchongyang");

	}

	@Test
	void get() {
		ValueOperations valueOperations = redisTemplate.opsForValue();
		Object o = valueOperations.get("key1");
		System.out.println(o);
	}

	@Test
	void hset() {
		HashOperations hashOperations = redisTemplate.opsForHash();
		hashOperations.put("key2", "name1", "zengziyuan");
	}

	@Test
	void hget() {
		HashOperations hashOperations = redisTemplate.opsForHash();
		Object o = hashOperations.get("key2", "name1");
		System.out.println(o);
	}

}
