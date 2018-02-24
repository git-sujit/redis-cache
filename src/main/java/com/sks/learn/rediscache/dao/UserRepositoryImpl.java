package com.sks.learn.rediscache.dao;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.sks.learn.rediscache.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private RedisTemplate<String, User> redisTemplate;

	private HashOperations<String, String, User> hashOperations;

	public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
		this.redisTemplate = redisTemplate;

		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(User user) {
		hashOperations.put("USER", user.getId(), user);
	}

	@Override
	public Map<String, User> findAll() {
		return hashOperations.entries("USER");
	}

	@Override
	public void update(User user) {
		save(user);

	}

	@Override
	public void delete(String id) {
		hashOperations.delete("USER", id);
	}

	@Override
	public User findById(String id) {
		return (User) hashOperations.get("USER", id);
	}

	public HashOperations<String, String, User> getHashOperations() {
		return hashOperations;
	}

	public void setHashOperations(HashOperations<String, String, User> hashOperations) {
		this.hashOperations = hashOperations;
	}

}
