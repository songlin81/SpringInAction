package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void string() {
		redisTemplate.opsForValue().set("num", 123);
		redisTemplate.opsForValue().set("string", "some strings");
		Object s = redisTemplate.opsForValue().get("num");
		Object s2 = redisTemplate.opsForValue().get("string");
		System.out.println(s);
		System.out.println(s2);
	}

	@Test
	public void string2() {
		Object s = redisTemplate.opsForValue().get("users::1");
		System.out.println(s.toString());
	}
}
