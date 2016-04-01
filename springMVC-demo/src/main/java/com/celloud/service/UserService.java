package com.celloud.service;

import java.util.List;
import java.util.Set;

import com.celloud.model.User;

public interface UserService {
    public List<User> findAll();

    public List<User> pageUsers(int start, int offset);

    public int countUsers();

    public User login(String username, String password);

    public Set<String> findRoles(long userId);

    public Set<String> findPermissions(long userId);

    public User findByUsername(String username);
}
