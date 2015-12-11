package com.celloud.service;

import java.util.List;

import com.celloud.model.User;
public interface UserService {
	public List<User> findAll();
	public List<User> pageUsers(int start,int offset);
	public int countUsers();
}
