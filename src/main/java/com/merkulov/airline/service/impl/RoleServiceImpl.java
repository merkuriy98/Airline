package com.merkulov.airline.service.impl;

import com.merkulov.airline.entity.Role;
import com.merkulov.airline.service.RoleService;

public class RoleServiceImpl implements RoleService {
    @Override
    public Role[] getRoles() {
        return Role.values();
    }
}
