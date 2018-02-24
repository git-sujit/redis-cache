package com.sks.learn.rediscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.sks.learn.rediscache.model.User;

@SpringBootApplication
public class RedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheApplication.class, args);
	}

	@Bean
	JedisConnectionFactory getJedisConnFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, User> getRedisTemplate() {
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(getJedisConnFactory());
		return redisTemplate;
	}
}
