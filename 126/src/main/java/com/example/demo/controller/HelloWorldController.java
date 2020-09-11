package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class HelloWorldController {

    @ApiOperation(value = "hello...", notes = "notes...")
    @RequestMapping("/hello")
    public String hello() throws Exception {
        return "HelloWorld, Spring Boot!";
    }

    @ApiIgnore
    @RequestMapping(value = "/ignoreApi")
    public String ignoreApi() {
        return "HelloWorld ,Spring Boot!";
    }
}