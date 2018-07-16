package com.celloud.demos.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.celloud.demos.model.User;
import com.celloud.demos.repository.UserRepository;
import com.celloud.demos.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserRepository userRepository;

	@Override
	public User login(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
}
