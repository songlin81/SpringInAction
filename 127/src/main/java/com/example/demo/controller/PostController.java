package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.net.URI;

@RestController
public class PostController {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/postForEntity")
    public User postForEntity() {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("name", "Song");
        paramMap.add("id", 4);
        ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://localhost:8080/postuser", paramMap, User.class);
        return responseEntity.getBody();
    }

    @RequestMapping("/postForObject")
    public String postForObject() {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("name", "Song");
        paramMap.add("id", 4);
        RestTemplate client = restTemplateBuilder.build();
        String response = client.postForObject("http://localhost:8080/postuser", paramMap, String.class);
        return response;
    }

    @RequestMapping("/postForLocation")
    public URI postForLocation() {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("name", "Song");
        paramMap.add("id", 4);
        RestTemplate client = restTemplateBuilder.build();
        URI response = client.postForLocation("http://localhost:8080/postuser", paramMap);
        return response;
    }
    @RequestMapping("/postForexchange")
    public String postForexchange() {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("name", "Song");
        paramMap.add("id", 4);
        RestTemplate client = restTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(paramMap,headers);
        ResponseEntity<String> response = client.exchange("http://localhost:8080/postuser",HttpMethod.POST,httpEntity,String.class,paramMap);
        return response.getBody();
    }
}