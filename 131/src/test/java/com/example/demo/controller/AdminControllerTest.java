package com.example.demo.controller;

import com.example.demo.dao.AdminDao;
import com.example.demo.dao.SysRoleDao;
import com.example.demo.entity.Admin;
import com.example.demo.entity.SysRole;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class AdminControllerTest {
    @Autowired
    private AdminDao adminDao;

    @Autowired
    private SysRoleDao sysRoleDao;

    @Test
    public void userInfoAdd() {
        Admin admin = new Admin();
        int hashIterations = 2;
        Object salt = "Songyan";
        Object credentials = "123456";
        String hashAlgorithmName = "MD5";
        Object simpleHash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        admin.setUsername("Song");
        admin.setPassword(simpleHash.toString());
        admin.setSalt("yan");
        admin.setPassword(simpleHash.toString());
        System.out.println(admin.getPassword());
//        List<SysRole> roles = new ArrayList<>();
//        SysRole role1 = sysRoleDao.findByRole("admin");
//        roles.add(role1);
//        admin.setRoleList(roles);
//        adminDao.save(admin);
    }
}