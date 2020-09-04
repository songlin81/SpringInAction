package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class propertTest {

    @Value("${quantity}")
    private int quantity;

    @Value("${tag}")
    private String tag;

    @Test
    public void getQuantity() {
        System.out.println(quantity);
    }

    @Test
    public void getTag() {
        System.out.println(tag);
    }

    @Autowired
    private GetChassisInfoProperties getChassisInfoProperties;
    @Test
    public void getChassisProperties() {
        System.out.println(getChassisInfoProperties.getProp()+" -- "+getChassisInfoProperties.getAmount());
    }
}
