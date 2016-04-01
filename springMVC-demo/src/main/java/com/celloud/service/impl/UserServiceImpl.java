package com.celloud.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.celloud.mapper.UserMapper;
import com.celloud.model.User;
import com.celloud.service.ResourceService;
import com.celloud.service.RoleService;
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
    @Resource
    private UserMapper userMapper;
    @Resource
    private ResourceService resourceService;
    @Resource
    private RoleService roleService;

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

    @Override
    public User login(String username, String password) {
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        return userMapper.login(username, password);
    }

    @Override
    public User findByUsername(String username) {
        System.out.println("find user by username:" + username);
        return userMapper.findByUsernameOrEmail(username);
    }

    @Override
    public Set<String> findRoles(long userId) {
        return roleService.findRolesByUserId(userId);
    }

    @Override
    public Set<String> findPermissions(long userId) {
        return resourceService.findPermissionResourcesByUserId(userId);
    }
}
