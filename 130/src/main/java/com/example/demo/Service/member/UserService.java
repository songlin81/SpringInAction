package com.example.demo.service.member;

import com.example.demo.entity.member.User;
import org.springframework.data.domain.Page;

public interface UserService {
    void save(User User);
    Page<User> PageByUser(Integer page, Integer size);
}

