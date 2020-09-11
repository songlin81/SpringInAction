package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.net.URI;

@RestController
public class PutAndDeleteController {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/put")
    public void put() {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("name", "Song");
        paramMap.add("id", 4);
        restTemplate.put("http://localhost:8080/", paramMap, User.class);
    }

    @RequestMapping("/delete")
    public void delete() {
        RestTemplate client= restTemplateBuilder.build();
        client.delete("http://localhost:8080/del/{1}", 8);
    }
}