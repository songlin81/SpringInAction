package com.example.demo.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/error")
public class TestErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }

    /*test err page
    http://localhost:8080/error/ok*/
    @RequestMapping("/ok")
    @ResponseBody
    public Map<String, Object> noError() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code ", 200);
        map.put("msg", "normal, for testing err page");
        return map;
    }

    @RequestMapping(value = "", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String errorHtml4040(HttpServletRequest request, HttpServletResponse response) {
        return "404 error, not exist";
    }

    @RequestMapping(value = "", consumes="application/json;charset=UTF-8",produces="application/json;charset=UTF-8")
    @ResponseBody
    public  Map<String, Object> errorJson() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rspCode", 404);
        map.put("rspMsg", "not exist");
        return map;
    }
}
