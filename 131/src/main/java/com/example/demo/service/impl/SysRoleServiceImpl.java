package com.example.demo.service.impl;

import com.example.demo.dao.SysRoleDao;
import com.example.demo.entity.SysRole;
import com.example.demo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public SysRole findByRole(String role) {
        return sysRoleDao.findByRole(role);
    }
}
