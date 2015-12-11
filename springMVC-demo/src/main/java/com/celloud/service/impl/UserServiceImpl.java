package com.celloud.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.celloud.model.User;
import com.celloud.service.UserService;
import com.celloud.utils.UserUtils;
/**
 * 
 * @author <a href="mailto:sunwendong@celloud.cn">sun8wd</a>
 * @date 2015年12月4日上午10:14:34
 * @version Revision: 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	private UserUtils userUtils = new UserUtils();
	@Override
	public List<User> findAll() {
		return userUtils.findALlUsers();
	}

	@Override
	public List<User> pageUsers(int start, int offset) {
		return userUtils.pageUsers(start, offset);
	}

	@Override
	public int countUsers() {
		return userUtils.countUsers();
	}
}
