package com.celloud.service;

import java.util.List;
import java.util.Set;

import com.celloud.model.Resource;

public interface ResourceService {

    Set<String> findPermissionResourcesByUserId(long userId);

    List<Resource> findAllResources();

}
