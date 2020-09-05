package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/map")
    public ModelAndView map() {
        Map user= new HashMap();
        user.put("name", "Song");
        user.put("sex", "male");
        ModelAndView modelAndView = new ModelAndView("map");
        modelAndView.addObject("map", user);
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView list() {
        List<Object> list = new ArrayList<Object>();
        list.add("Beijing");
        list.add("Shanghai");
        list.add("Tianjin");
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/list2")
    public ModelAndView list2() {
        List<User> list = new ArrayList<>();
        list.add(new User(1,"name1"));
        list.add(new User(2,"name2"));
        list.add(new User(3,"name3"));
        ModelAndView modelAndView = new ModelAndView("list2");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/variable")
    public ModelAndView variable() {
        ModelAndView modelAndView = new ModelAndView("thymeleaf");
        String name = "Song";
        Integer age = 39;
        modelAndView.addObject("name", name);
        modelAndView.addObject("age", age);

        return modelAndView;
    }
}
