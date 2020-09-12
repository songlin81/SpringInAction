package com.example.demo.service;

import com.example.demo.entity.Admin;

public interface AdminService {
    public Admin findByUsername(String username);
}
