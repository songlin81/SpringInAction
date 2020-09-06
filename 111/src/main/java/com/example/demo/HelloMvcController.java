package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloMvcController {
    @RequestMapping("/helloworld")
    public String helloWorld (Model model)  throws Exception{
        model.addAttribute("mav", "Hello ,Spring Boot!");
        return "example/hello";
    }
}

