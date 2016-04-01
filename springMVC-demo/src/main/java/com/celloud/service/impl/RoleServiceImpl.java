package com.celloud.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.celloud.mapper.RoleMapper;
import com.celloud.model.Role;
import com.celloud.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public Set<String> findRolesByUserId(long userId) {
        List<Role> roles = roleMapper.findRolesByUserId(userId);
        Set<String> roleNames = new HashSet<>();
        if (roles != null && !roles.isEmpty()) {
            for (Role role : roles) {
                roleNames.add(role.getName());
            }
        }
        return roleNames;
    }

}
