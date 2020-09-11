package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostTest {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void postForEntity() {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("name", "Song");
        paramMap.add("id", 4);
        ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://localhost:8080/postuser", paramMap, User.class);
        System.out.println(responseEntity.getBody().getName());
    }

    @Test
    public void postForObject() {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("name", "Song");
        paramMap.add("id", 4);
        RestTemplate client = restTemplateBuilder.build();
        String response = client.postForObject("http://localhost:8080/postuser", paramMap, String.class);
        System.out.println(response);
    }

    @Test
    public void postForLocation() {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("name", "Song");
        paramMap.add("id", 4);
        RestTemplate client = restTemplateBuilder.build();
        URI response = client.postForLocation("http://localhost:8080/post",paramMap);
        System.out.println(response);
    }

    @Test
    public void postForexchange() {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("name", "Song");
        paramMap.add("id", 4);
        RestTemplate client = restTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(paramMap,headers);
        ResponseEntity<String> response = client.exchange("http://localhost:8080/postuser", HttpMethod.POST,httpEntity,String.class,paramMap);
        System.out.println(response.getBody());
    }

    @Test
    public void put() {
        RestTemplate client= restTemplateBuilder.build();
        User user = new User();
        user.setName("Song");
        user.setId(5);
        client.put("http://localhost:8080/", user);
    }

    @Test
    public void delete() {
        RestTemplate client= restTemplateBuilder.build();
        client.delete("http://localhost:8080/del/{1}", 4);
    }
}