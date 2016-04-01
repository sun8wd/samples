package com.celloud.service;

import java.util.Set;

public interface PermissionService {

    Set<String> findPermissionsByUserId(int userId);

}
