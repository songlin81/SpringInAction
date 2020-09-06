package com.example.demo.config;

import com.example.demo.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean("user1")
    public User user() {
        User user = new User();
        user.setId(1);
        user.setName("Song");
        return user;
    }
}