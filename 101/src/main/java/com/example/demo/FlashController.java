package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@RestController
public class FlashController {
    @RequestMapping("/flash")
    public String flashAPI()  throws Exception{
        return "Spring boot flash message!";
    }
}
