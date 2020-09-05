package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloMvcController {

    @RequestMapping("/helloworld")
    public String helloWorld(Model model) throws Exception {
        model.addAttribute("mav", "HelloWorldController, Spring Boot!");
        return "example/hello";
    }

    @GetMapping("/mvcdemo")
    public ModelAndView hello() {
        User user=new User(1, "Song", 39);
        ModelAndView modelAndView=new ModelAndView("mvcdemo");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
}
