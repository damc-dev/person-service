package com.dmcelligott.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmcelligott.user.dao.UserRepository;
import com.dmcelligott.user.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public User save(User user) throws UserServiceException {
		if (!repository.findByUserName(user.getUserName()).isEmpty()) {
			throw new UserServiceException("The username specified already exists");
		} else {
			System.out.println("Saved: " + user.toString());
			return repository.save(user);
		}
	}

	@Override
	public Iterable<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<User> findByUserName(String userName) {
		return repository.findByUserName(userName);
	}

}
