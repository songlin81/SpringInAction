package com.example.demo.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "users")
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Cacheable(key ="#p0")
    public User selectUser(String id){
        System.out.println("select");
        return userMapper.findById(id);
    }

    @CachePut(key = "#p0")
    public void updataById(User user){
        System.out.println("update");
        userMapper.updateById(user);
    }

    @CacheEvict(key ="#p0",allEntries=true)
    public void deleteById(String id){
        System.out.println("delete");
        userMapper.deleteById(id);
    }
}