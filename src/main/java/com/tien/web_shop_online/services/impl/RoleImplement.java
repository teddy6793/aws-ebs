package com.tien.web_shop_online.services.impl;

import com.tien.web_shop_online.entities.Role;
import com.tien.web_shop_online.repositories.RoleRepository;
import com.tien.web_shop_online.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleImplement implements RoleService {

    @Autowired
    private RoleRepository rp;

    @Override
    public void saveRole(Role role) {
        rp.save(role);
    }

    @Override
    public void deleteRoleById(Integer id) {
        rp.deleteById(id);
    }

    @Override
    public List<Role> findAllRole() {
        return rp.findAll();
    }

    @Override
    public Role getRoleById(Integer id) {
        return rp.getById(id);
    }
}
