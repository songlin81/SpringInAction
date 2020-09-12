package com.example.demo.controller;

import com.example.demo.util.result.ExceptionMsg;
import com.example.demo.util.result.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
    protected Logger logger =  LoggerFactory.getLogger(this.getClass());
    protected Response result(ExceptionMsg msg){
        logger.error(msg.getCode() + " : " + msg.getMsg());
        return new Response(msg);
    }
    protected Response result(){
        return new Response();
    }
}
