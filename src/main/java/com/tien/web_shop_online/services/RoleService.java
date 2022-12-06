package com.tien.web_shop_online.services;


import com.tien.web_shop_online.entities.Role;

import java.util.List;

public interface RoleService {
    void saveRole(Role role);
    void deleteRoleById(Integer id);
    List<Role> findAllRole();
    Role getRoleById(Integer id);
}
