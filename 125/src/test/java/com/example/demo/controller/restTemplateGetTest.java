package com.example.demo.controller;

import com.example.demo.entity.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class restTemplateGetTest {
    @Test
    public void restTemplateGetTest(){
        RestTemplate restTemplate = new RestTemplate();
        Article article = restTemplate.getForObject("http://localhost:8080/article/2", Article.class);
        System.out.println(article);
        System.out.println("---");
    }
}