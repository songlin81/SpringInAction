package com.example.demo.service.impl;

import com.example.demo.dao.AdminDao;
import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    @Override
    public Admin findByUsername(String username) {
        return adminDao.findByUsername(username);
    }
}