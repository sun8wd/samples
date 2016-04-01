package com.celloud.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.celloud.mapper.ResourceMapper;
import com.celloud.model.Resource;
import com.celloud.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {
    @javax.annotation.Resource
    private ResourceMapper resourceMapper;

    @Override
    public Set<String> findPermissionResourcesByUserId(long userId) {
        List<Resource> resources = resourceMapper.findPermissionResourcesByUserId(userId);
        Set<String> permissions = new HashSet<>();
        if (resources != null && !resources.isEmpty()) {
            for (Resource resource : resources) {
                permissions.add(resource.getPermission());
            }
        }
        return permissions;
    }

    @Override
    public List<Resource> findAllResources() {
        return resourceMapper.findAllResources();
    }
}
