package com.celloud.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.celloud.service.PermissionService;
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Override
    public Set<String> findPermissionsByUserId(int userId) {
        // TODO Auto-generated method stub
        return null;
    }

}
