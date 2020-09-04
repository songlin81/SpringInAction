package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class applicationPropertyTest {
    @Autowired
    private GetApplicationProperties getApplicationProperties;

    @Test
    public void getSection() {
        System.out.println(getApplicationProperties.getSection());
    }

    @Test
    public void getSectionNo() {
        System.out.println(getApplicationProperties.getSectionNo());
    }

    @Test
    public void getAddress() {
        System.out.println(getApplicationProperties.getAddress());
    }
}
