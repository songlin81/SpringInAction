package com.example.demo.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import java.io.Serializable;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User implements Serializable {
    private String id;
    private String name;
    private int age;
    User(){};
}
