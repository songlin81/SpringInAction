package com.example.demo.service;

import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.security.RolesAllowed;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String addUser() {
        System.out.println("addUser");
        return null;
    }

    @Override
    @RolesAllowed({"ROLE_USER","ROLE_ADMIN"})
    public String updateUser() {
        System.out.println("updateUser");
        return null;
    }

    @Override
    @RolesAllowed("ROLE_ADMIN")
    public String deleteUser() {
        System.out.println("delete");
        return null;
    }
}