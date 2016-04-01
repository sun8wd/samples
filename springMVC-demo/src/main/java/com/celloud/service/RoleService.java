package com.celloud.service;

import java.util.Set;

public interface RoleService {

    Set<String> findRolesByUserId(long userId);

}
