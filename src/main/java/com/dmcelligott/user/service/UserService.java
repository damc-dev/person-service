package com.dmcelligott.user.service;

import java.util.List;

import com.dmcelligott.user.model.User;

public interface UserService {
	
 public User save(User user) throws UserServiceException;
 
 public Iterable<User> findAll();
 
 public User findOne(Long id);
 
 public List<User> findByUserName(String userName);
}
