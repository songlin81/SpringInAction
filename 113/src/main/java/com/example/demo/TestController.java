package com.example.demo;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAspectJAutoProxy
public class TestController {
    @RequestMapping("/")
    @MyTestAnnotation("...Test Annotation...")
    public void testAnnotation() {
        System.err.println("Test customized annotation");
    }

}
