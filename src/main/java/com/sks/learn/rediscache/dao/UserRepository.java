package com.sks.learn.rediscache.dao;

import java.util.Map;

import com.sks.learn.rediscache.model.User;

public interface UserRepository {
	void save(User user);

	Map<String, User> findAll();

	void update(User user);

	void delete(String id);

	User findById(String id);
}
